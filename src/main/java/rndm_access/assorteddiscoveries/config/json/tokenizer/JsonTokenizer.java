package rndm_access.assorteddiscoveries.config.json.tokenizer;

import rndm_access.assorteddiscoveries.config.json.exceptions.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

public class JsonTokenizer {
    private int line;
    private int index;
    private Character curChar;
    private final List<String> source;

    public JsonTokenizer(List<String> source) {
        this.line = 0;
        this.index = 0;
        this.source = source;
        this.curChar = findFirstChar(this.source);
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

    public TokenList tokenize() {
        ArrayList<Token> jsonTokens = new ArrayList<>();

        // If the first character was not found then the file is empty!
        if (curChar == null) {
            return new TokenList(jsonTokens);
        }

        while (hasNextChar()) {
            consumeWhitespace();
            consumeComment();

            if (curChar == '"') {
                StringBuilder stringBuilder = new StringBuilder();
                Token token = scanString(stringBuilder);
                jsonTokens.add(token);
            } else if (curChar == ':') {
                Token token = new Token.Builder().setType(TokenType.COLON)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else if (curChar == '{') {
                Token token = new Token.Builder().setType(TokenType.LEFT_CURLY)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else if (curChar == '}') {
                Token token = new Token.Builder().setType(TokenType.RIGHT_CURLY)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else if (curChar == '[') {
                Token token = new Token.Builder().setType(TokenType.LEFT_BRACKET)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else if (curChar == ']') {
                Token token = new Token.Builder().setType(TokenType.RIGHT_BRACKET)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else if (curChar == ',') {
                Token token = new Token.Builder().setType(TokenType.COMMA)
                        .setValue(String.valueOf(curChar)).setLine(line).setStart(index).setEnd(index).build();
                jsonTokens.add(token);
                consumeChar();
            } else {
                Token token = scanObject();

                jsonTokens.add(token);
            }
        }
        return new TokenList(jsonTokens);
    }

    private void consumeComment() {
        if (curChar == '/') {
            consumeChar();
            consumeWhitespace();

            if (curChar == '/') {
                advanceLine();
                consumeWhitespace();
            }
        }
    }

    private void consumeWhitespace() {
        while (Character.isWhitespace(curChar)) {
            consumeChar();
        }
    }

    private Token scanObject() {
        Token.Builder tokenBuilder = new Token.Builder();
        StringBuilder objectBuilder = new StringBuilder();

        tokenBuilder.setLine(line);
        tokenBuilder.setStart(index);
        while (hasNextChar() && curChar != '"' && curChar != ':' && curChar != ',' && curChar != '{'
                && curChar != '}' && curChar != '[' && curChar != ']') {
            if(!Character.isWhitespace(curChar)) {
                objectBuilder.append(curChar);
                tokenBuilder.setEnd(index + 1);
            }
            consumeChar();
        }
        String value = objectBuilder.toString();

        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return tokenBuilder.setType(TokenType.BOOL).setValue(value.toLowerCase()).build();
        } else if (isInteger(value)) {
            return tokenBuilder.setType(TokenType.INT).setValue(value).build();
        } else {
            return tokenBuilder.setType(TokenType.ERROR).setValue(value).build();
        }
    }

    private Token scanString(StringBuilder builder) {
        Token.Builder token = new Token.Builder().setType(TokenType.STRING).setLine(line);
        token.setStart(index);
        require('"');
        consumeChar();

        while (hasNextCharOnLine() && curChar != '"') {
            builder.append(curChar);
            consumeChar();
        }
        token.setEnd(index + 1);
        require('"');
        consumeChar();
        token.setValue(builder.toString());
        return token.build();
    }

    private boolean hasNextChar() {
        if((line + 1) == source.size()) {
            return index < source.get(line).length();
        }
        return line < source.size();
    }

    private boolean hasNextCharOnLine() {
        String lineContent = source.get(line);
        int nextIndex = index + 1;

        return nextIndex < lineContent.length();
    }

    private void require(char character) {
        if (this.curChar != character) {
            throw new JsonSyntaxException("Expected '" + character
                    + "', got '" + this.curChar
                    + "' at line " + (this.line + 1)
                    + " and column " + (this.index + 1));
        }
    }

    private void consumeChar() {
        String jsonLine = source.get(line);
        index++;

        if (index < jsonLine.length()) {
            curChar = jsonLine.charAt(index);
        } else {
            advanceLine();
        }
    }

    private void advanceLine() {
        line++;
        index = 0;

        if(line < source.size()) {
            String jsonLine = source.get(line);

            if(!jsonLine.isEmpty()) {
                curChar = jsonLine.charAt(index);
            } else {
                advanceLine();
            }
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
