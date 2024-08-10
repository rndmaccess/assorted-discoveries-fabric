package rndm_access.assorteddiscoveries.config.json.tokenizer;

import java.util.Objects;

public record JsonToken(TokenType type, String value, int line, int column) {

    public boolean match(TokenType tokenType) {
        return Objects.equals(type, tokenType);
    }
}
