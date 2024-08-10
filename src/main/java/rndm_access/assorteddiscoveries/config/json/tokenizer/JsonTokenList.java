package rndm_access.assorteddiscoveries.config.json.tokenizer;

import java.util.LinkedList;

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

    public JsonToken peek() {
        int nextPos = position + 1;

        return tokenList.get(nextPos);
    }

    public boolean hasNextToken() {
        return position < tokenList.size();
    }
}
