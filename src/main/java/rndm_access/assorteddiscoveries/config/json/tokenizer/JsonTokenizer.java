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

public class JsonTokenizer {
    private int lineNum;
    private int pos;
    private Character curChar;
    private final Path path;
    private final ArrayList<Token> jsonTokens;

    public JsonTokenizer(Path path) {
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

            if (consumeComment(line)) {
                break;
            }

            if (curChar == '"') {
                StringBuilder stringBuilder = new StringBuilder();
                Token token = scanString(line, stringBuilder);
                jsonTokens.add(token);
            } else if (curChar == ':') {
                Token token = new Token.Builder().setType(TokenType.COLON)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '{') {
                Token token = new Token.Builder().setType(TokenType.LEFT_CURLY)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '}') {
                Token token = new Token.Builder().setType(TokenType.RIGHT_CURLY)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == '[') {
                Token token = new Token.Builder().setType(TokenType.LEFT_BRACKET)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == ']') {
                Token token = new Token.Builder().setType(TokenType.RIGHT_BRACKET)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
                jsonTokens.add(token);
                consumeChar(line);
            } else if (curChar == ',') {
                Token token = new Token.Builder().setType(TokenType.COMMA)
                        .setValue(String.valueOf(curChar)).setLine(lineNum).build();
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

    private boolean consumeComment(String line) {
        if (curChar == '/') {
            consumeChar(line);
            consumeWhitespace(line);

            if (curChar == '/') {
                consumeWhitespace(line);
                return true; // If we return true here we advance to the next line!
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
        Token.Builder tokenBuilder = new Token.Builder();
        StringBuilder objectBuilder = new StringBuilder();

        tokenBuilder.setLine(lineNum);
        while (pos < line.length() && curChar != '"' && curChar != ':' && curChar != ',' && curChar != '{'
                && curChar != '}' && curChar != '[' && curChar != ']') {
            if(!Character.isWhitespace(curChar)) {
                objectBuilder.append(curChar);
            }
            consumeChar(line);
        }
        String value = objectBuilder.toString();
        boolean isBool = value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");

        if (isBool || isInteger(value)) {
            return tokenBuilder.setType(TokenType.VALUE).setValue(value.toLowerCase()).build();
        } else {
            return tokenBuilder.setType(TokenType.ERROR).setValue(value).build();
        }
    }

    private Token scanString(String line, StringBuilder builder) throws JsonSyntaxException {
        Token.Builder token = new Token.Builder().setLine(lineNum);
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
            token.setType(TokenType.KEY);
        } else {
            token.setType(TokenType.VALUE);
        }

        token.setValue(builder.toString());
        return token.build();
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

    private boolean isInteger(String value) {
        for (int i = 0; i < value.length(); i++) {
            if(!Character.isDigit(value.charAt(i)) && value.charAt(0) != '-') {
                return false;
            }
        }
        return true;
    }
}
