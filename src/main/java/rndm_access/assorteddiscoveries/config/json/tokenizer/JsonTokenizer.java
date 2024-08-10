package rndm_access.assorteddiscoveries.config.json.tokenizer;

import rndm_access.assorteddiscoveries.config.json.JsonSyntaxException;

import java.util.LinkedList;
import java.util.List;

public class JsonTokenizer {
    private int line;
    private int column;
    private Character curChar;
    private List<String> source;

    public JsonTokenizer(List<String> source) {
        this.line = 0;
        this.column = 0;
        this.source = source;
        this.curChar = findFirstChar(source);
    }

    private Character findFirstChar(List<String> source) {
        while (!source.isEmpty()) {
            if(!source.get(line).isEmpty()) {
                return source.get(line).charAt(0);
            }
            line++;
        }
        return null;
    }

    public JsonTokenList tokenize() {
        JsonTokenList jsonTokens = new JsonTokenList();

        if (curChar == null) {
            return jsonTokens;
        }

        source = consumeWhitespace();
        while (hasNextChar()) {
            consumeComment();
            if (isNotSpecialCharacter()) {
                String value = scanValue();

                if(!value.isEmpty()) {
                    jsonTokens.add(new JsonToken(TokenType.OBJECT, value, line, column));
                }
            } else if (curChar == '"') {
                StringBuilder stringBuilder = new StringBuilder();
                scanString(stringBuilder);
                jsonTokens.add(new JsonToken(TokenType.STRING, stringBuilder.toString(), line, column));
            } else if (curChar == ':') {
                jsonTokens.add(new JsonToken(TokenType.COLON, String.valueOf(curChar), line, column));
                consumeChar();
            } else if (curChar == '{') {
                jsonTokens.add(new JsonToken(TokenType.LEFT_CURLY, String.valueOf(curChar), line, column));
                consumeChar();
            } else if (curChar == '}') {
                jsonTokens.add(new JsonToken(TokenType.RIGHT_CURLY, String.valueOf(curChar), line, column));
                consumeChar();
            } else if (curChar == '[') {
                jsonTokens.add(new JsonToken(TokenType.LEFT_BRACKET, String.valueOf(curChar), line, column));
                consumeChar();
            } else if (curChar == ']') {
                jsonTokens.add(new JsonToken(TokenType.RIGHT_BRACKET, String.valueOf(curChar), line, column));
                consumeChar();
            } else {
                jsonTokens.add(new JsonToken(TokenType.COMMA, String.valueOf(curChar), line, column));
                consumeChar();
            }
        }
        return jsonTokens;
    }

    private List<String> consumeWhitespace() {
        List<String> newSource = new LinkedList<>();
        boolean isQuoted = false; // This allows strings to span multiple lines!

        for (String line : source) {
            StringBuilder finishedLine = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '"' || isQuoted) {
                    isQuoted = true;

                    do {
                        finishedLine.append(line.charAt(i));
                        i++;
                    } while (i < line.length() && line.charAt(i) != '"');

                    if (i < line.length()) {
                        finishedLine.append(line.charAt(i));
                    }

                    if (i < line.length() && line.charAt(i) == '"') {
                        isQuoted = false;
                    }
                } else {
                    if (!Character.isWhitespace(line.charAt(i))) {
                        finishedLine.append(line.charAt(i));
                    }
                }
            }
            newSource.add(finishedLine.toString());
        }
        return newSource;
    }

    private void consumeComment() {
        if (curChar == '/') {
            consumeChar();

            if (curChar == '/') {
                advanceLine();
            }
        }
    }

    private String scanValue() {
        StringBuilder valueBuilder = new StringBuilder();

        if (curChar == '"') {
            scanString(valueBuilder);
        } else {
            while (hasNextChar() && isNotSpecialCharacter()) {
                if(!Character.isWhitespace(curChar)) {
                    valueBuilder.append(curChar);
                }
                consumeChar();
            }
        }
        return valueBuilder.toString();
    }

    private void scanString(StringBuilder builder) {
        if (require('"')) {
            consumeChar();

            while (hasNextChar() && isNotSpecialCharacter()) {
                builder.append(curChar);
                consumeChar();
            }
            require('"');
            consumeChar();
        }
    }

    private boolean hasNextChar() {
        if((line + 1) == source.size()) {
            return column < source.get(line).length();
        }
        return line < source.size();
    }

    private boolean require(char character) {
        if(this.curChar != character) {
            throw new JsonSyntaxException("Expected " + character
                    + " but found " + this.curChar
                    + " at line " + (this.line + 1)
                    + " and column " + (this.column + 1));
        }
        return true;
    }

    public Character peek() {
        String jsonLine = source.get(line);
        int nextColumn = column + 1;

        if(nextColumn < jsonLine.length()) {
            return jsonLine.charAt(nextColumn);
        } else {
            int nextLine = line + 1;

            if (nextLine < source.size() - 1) {
                return source.get(nextLine).charAt(0);
            }
        }
        return null;
    }

    private void consumeChar() {
        String jsonLine = source.get(line);
        column++;

        if (column < jsonLine.length()) {
            curChar = jsonLine.charAt(column);
        } else {
            if(line < source.size() - 1) {
                advanceLine();
            }
        }
    }

    private void advanceLine() {
        line++;
        column = 0;
        String jsonLine = source.get(line);
        curChar = jsonLine.charAt(column);
    }

    private boolean isNotSpecialCharacter() {
        return curChar != '"' && curChar != ':' && curChar != ','
                && curChar != '{' && curChar != '}'
                && curChar != '[' && curChar != ']';
    }
}
