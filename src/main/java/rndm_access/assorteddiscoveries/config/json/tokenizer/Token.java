package rndm_access.assorteddiscoveries.config.json.tokenizer;

public class Token {
    private final TokenType type;
    private final String value;
    private final int line;

    protected Token(Token.Builder builder) {
        this.type = builder.type;
        this.value = builder.value;
        this.line = builder.line;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public static class Builder {
        private TokenType type;
        private String value;
        private int line;

        public Builder setType(TokenType type) {
            this.type = type;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setLine(int line) {
            this.line = line;
            return this;
        }

        public Token build() {
            return new Token(this);
        }
    }
}
