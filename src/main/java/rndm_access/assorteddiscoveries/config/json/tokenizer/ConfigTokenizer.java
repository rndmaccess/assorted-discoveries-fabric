package rndm_access.assorteddiscoveries.config.json.tokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonConfigException;
import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ConfigTokenizer {
    private int lineNum;
    private int pos;
    private Character curChar;
    private final Path path;
    private final ArrayList<Token> jsonTokens;

    public ConfigTokenizer(Path path) {
        this.lineNum = 0;
        this.pos = 0;
        this.path = path;
        this.jsonTokens = new ArrayList<>();
    }

    public TokenList tokenize() throws JsonSyntaxException {
        File file = new File(String.valueOf(path));

        if (path == null || !Files.exists(path)) {
            throw new JsonConfigException("Couldn't load config at " + path + " because it does not exist!");
        }

        try (LineIterator iterator = FileUtils.lineIterator(file)) {
            while (iterator.hasNext()) {
                String line = iterator.next();
                this.tokenizeLine(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new TokenList(jsonTokens);
    }

    private void tokenizeLine(String line) throws JsonSyntaxException {
        // If the line is empty we don't have to tokenize it!
        if (line.isEmpty()) {
            return;
        }

        this.curChar = line.charAt(pos);

        while (pos < line.length()) {
            consumeWhitespace(line);

            if (isComment(line)) {
                Token comment = scanComment(line);
                jsonTokens.add(comment);
            } else if (curChar == '"') {
                StringBuilder stringBuilder = new StringBuilder();
                Token token = scanString(line, stringBuilder);
                jsonTokens.add(token);
            } else if (curChar == ':') {
                Token token = new Token(TokenType.COLON, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '{') {
                Token token = new Token(TokenType.LEFT_CURLY, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '}') {
                Token token = new Token(TokenType.RIGHT_CURLY, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '[') {
                Token token = new Token(TokenType.LEFT_BRACKET, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == ']') {
                Token token = new Token(TokenType.RIGHT_BRACKET, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == ',') {
                Token token = new Token(TokenType.COMMA, String.valueOf(curChar), lineNum);
                jsonTokens.add(token);
                consumeChar(line);
            } else {
                Token token = scanObject(line);
                jsonTokens.add(token);
            }
        }
        pos = 0;
        lineNum++;
    }

    private boolean isComment(String line) {
        if (curChar == '/') {
            consumeChar(line);
            consumeWhitespace(line);

            if (curChar == '/') {
                consumeWhitespace(line);
                consumeChar(line);
                return true;
            }
        }
        return false;
    }

    private void consumeWhitespace(String line) {
        while (Character.isWhitespace(curChar)) {
            consumeChar(line);
        }
    }

    private Token scanObject(String line) {
        StringBuilder objectBuilder = new StringBuilder();
        int tokenLine = lineNum;

        // At this point we don't know if it's a key, value, or error
        while (pos < line.length() && curChar != '"' && curChar != ':' && curChar != ',' && curChar != '{'
                && curChar != '}' && curChar != '[' && curChar != ']') {
            if(!Character.isWhitespace(curChar)) {
                objectBuilder.append(curChar);
            }
            consumeChar(line);
        }
        String value = objectBuilder.toString();

        // If we find a colon after parsing it must be a key!
        if (curChar == ':') {
            return new Token(TokenType.KEY, value.toLowerCase(), tokenLine);
        }

        boolean isBool = value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");

        if (isBool) {
            return new Token(TokenType.VALUE, value.toLowerCase(), tokenLine);
        }
        return new Token(TokenType.ERROR, value, tokenLine);
    }

    private Token scanString(String line, StringBuilder builder) throws JsonSyntaxException {
        int tokenLine = lineNum;
        requireQuote();
        consumeChar(line);
        builder.append('"');
        while (pos < line.length() && curChar != '"') {
            builder.append(curChar);
            consumeChar(line);
        }
        builder.append('"');
        requireQuote();
        consumeChar(line);
        consumeWhitespace(line);

        if (curChar == ':') {
            return new Token(TokenType.KEY, builder.toString(), tokenLine);
        }
        return new Token(TokenType.VALUE, builder.toString(), tokenLine);
    }

    private Token scanComment(String line) throws JsonSyntaxException {
        StringBuilder comment = new StringBuilder();

        consumeWhitespace(line);
        while (pos < line.length()) {
            comment.append(line.charAt(pos));
            consumeChar(line);
        }
        return new Token(TokenType.COMMENT, comment.toString(), lineNum);
    }

    private void consumeChar(String line) {
        pos++;

        if (pos < line.length()) {
            curChar = line.charAt(pos);
        }
    }

    private void requireQuote() throws JsonSyntaxException {
        if (this.curChar != '"') {
            int reportedLine = this.lineNum + 1;

            throw new JsonSyntaxException("Expected '" + '"'
                    + "', got '" + this.curChar
                    + "' at line " + reportedLine);
        }
    }
}
