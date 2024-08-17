package rndm_access.assorteddiscoveries.config.json.tokenizer;

import java.util.LinkedList;
import java.util.Objects;

public class JsonTokenList {
    private int position;
    private final LinkedList<JsonToken> tokenList;

    public JsonTokenList() {
        this.position = 0;
        this.tokenList = new LinkedList<>();
    }

    public void add(JsonToken token) {
        tokenList.add(token);
    }

    public JsonToken get() {
        return this.tokenList.get(position);
    }

    public JsonToken consumeToken() {
        return tokenList.get(position++);
    }

    public JsonToken getNext() {
        int nextPos = position + 1;

        if (tokenList.size() == nextPos) {
            return null;
        }
        return tokenList.get(nextPos);
    }

    /**
     * @param tokenType The token type to match
     * @return true if the next token's type matches the type passed in.
     *         If the list does not have another token then the method returns false.
     */
    public boolean matchNext(TokenType tokenType) {
        if(this.getNext() == null) {
            return false;
        }
        return Objects.equals(this.getNext().type(), tokenType);
    }

    public boolean match(TokenType... tokenTypes) {
        for (TokenType tokenType : tokenTypes) {
            if(Objects.equals(tokenList.get(position).type(), tokenType)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchAndConsume(TokenType type) {
        if (this.match(type)) {
            consumeToken();
            return true;
        }
        return false;
    }

    public boolean hasNextToken() {
        return position < tokenList.size() - 1;
    }

    public boolean isEmpty() {
        return tokenList.isEmpty();
    }
}
