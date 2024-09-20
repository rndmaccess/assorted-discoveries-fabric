package rndm_access.assorteddiscoveries.config.json.tokenizer;

public class JsonToken {
    private TokenType type;
    private String value;
    private int line;
    private int start;
    private int end;

    protected JsonToken(JsonToken.Builder builder) {
        this.type = builder.type;
        this.value = builder.value;
        this.line = builder.line;
        this.start = builder.start;
        this.end = builder.end;
    }

    public JsonToken() {
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

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static class Builder {
        private TokenType type;
        private String value;
        private int line;
        private int start;
        private int end;

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

        public Builder setStart(int start) {
            this.start = start;
            return this;
        }

        public Builder setEnd(int end) {
            this.end = end;
            return this;
        }

        public JsonToken build() {
            return new JsonToken(this);
        }
    }
}
