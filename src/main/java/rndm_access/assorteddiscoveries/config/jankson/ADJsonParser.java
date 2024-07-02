package rndm_access.assorteddiscoveries.config.jankson;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.JsonObject;

import java.util.LinkedList;

public class ADJsonParser {
    private int parseIndex;
    private final String json;

    public ADJsonParser(JsonObject json) {
        parseIndex = 0;
        this.json = removeWhitespace(json.toJson());
    }

    public LinkedList<ADJsonConfigCategory> parseJsonFile() {
        LinkedList<ADJsonConfigCategory> categories = new LinkedList<>();

        while (parseIndex < json.length()) {
            ADJsonConfigCategory mainCategory = parseMainCategory();

            if (mainCategory != null) {
                parseSubCategoriesAndEntries(mainCategory);
                categories.add(mainCategory);
                parseIndex++;
            } else {
                return categories;
            }
        }
        return categories;
    }

    private ADJsonConfigCategory parseMainCategory() {
        StringBuilder categoryNameBuilder = new StringBuilder();
        parseString(categoryNameBuilder);

        if (!hasNextToken()) {
            return null;
        }

        if (json.charAt(parseIndex) == ':' && json.charAt(parseIndex + 1) == '{') {
            parseIndex += 2;
            return new ADJsonConfigCategory(categoryNameBuilder.toString());
        }
        parseIndex++;
        return parseMainCategory();
    }

    private void parseSubCategoriesAndEntries(ADJsonConfigCategory category) {
        while (!match(',') && !match('}')) {
            StringBuilder keyNameBuilder = new StringBuilder();
            parseString(keyNameBuilder);

            if (hasNextToken() && match(':')) {
                parseIndex++;
                if (match('{')) {
                    parseIndex++;
                    ADJsonConfigCategory subCategory = new ADJsonConfigCategory(keyNameBuilder.toString());
                    category.addSubCategory(subCategory);
                    parseSubCategoriesAndEntries(subCategory);
                } else {
                    String value = parseValue();
                    category.addEntry(new ADJsonConfigEntry(keyNameBuilder.toString(), value));
                }
            }
            parseIndex++;
        }
    }

    private String parseValue() {
        StringBuilder valueBuilder = new StringBuilder();

        if (match('"')) {
            parseString(valueBuilder);
        } else {
            do {
                valueBuilder.append(json.charAt(parseIndex));
                parseIndex++;
            } while (hasNextToken() && !match(',') && !match('}'));
        }
        return valueBuilder.toString();
    }

    private void parseString(StringBuilder builder) {
        if (match('"')) {
            parseIndex++;

            while (hasNextToken() && !match('"')) {
                builder.append(json.charAt(parseIndex));
                parseIndex++;
            }
            parseIndex++;
        }
    }

    private static String removeWhitespace(String json) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < json.length(); i++) {
            char token = json.charAt(i);

            // Keep the quotes and spaces within strings
            if (token == '"') {
                do {
                    builder.append(json.charAt(i));
                    i++;
                    token = json.charAt(i);
                } while (token != '"');
            }

            if (!Character.isWhitespace(token)) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }

    private boolean hasNextToken() {
        return (parseIndex + 1) < json.length();
    }

    private boolean match(char token) {
        return json.charAt(parseIndex) == token;
    }
}
