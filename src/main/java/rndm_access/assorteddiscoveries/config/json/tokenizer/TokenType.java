package rndm_access.assorteddiscoveries.config.json.tokenizer;

import net.minecraft.util.StringIdentifiable;

public enum TokenType implements StringIdentifiable {
    LEFT_CURLY("{"), RIGHT_CURLY("}"),
    LEFT_BRACKET("["), RIGHT_BRACKET("]"),
    COLON(":"), COMMA(","),

    STRING("string"), INT("integer"), BOOL("boolean"),

    ERROR("error");

    private final String string;

    TokenType(String string) {
        this.string = string;
    }

    @Override
    public String asString() {
        return string;
    }
}
