package rndm_access.assorteddiscoveries.config.json.tokenizer;

import java.util.LinkedList;
import java.util.Objects;

public class TokenList {
    private int position;
    private final LinkedList<Token> tokenList;

    public TokenList() {
        this.position = 0;
        this.tokenList = new LinkedList<>();
    }

    public void add(Token token) {
        tokenList.add(token);
    }

    public Token get() {
        return this.tokenList.get(position);
    }

    public Token consumeToken() {
        return tokenList.get(position++);
    }

    /**
     * @param tokenTypes The token types to match
     * @return true if the at least one of the token types match the current token.
     *         If the current index is greater than the number of elements
     *         in the list then false.
     */
    public boolean match(TokenType... tokenTypes) {
        if(position >= tokenList.size()) {
            return false;
        }

        for (TokenType tokenType : tokenTypes) {
            if(Objects.equals(tokenList.get(position).getType(), tokenType)) {
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
