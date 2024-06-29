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

        while(parseIndex < json.length()) {
            StringBuilder categoryBuilder = new StringBuilder();

            // Parse the category
            while(hasNextChar() && json.charAt(parseIndex) != ':' && json.charAt(parseIndex + 1) != '{') {
                parseString(categoryBuilder);
                parseIndex++;
            }

            ADJsonConfigCategory category = new ADJsonConfigCategory(categoryBuilder.toString());

            // Parse the entries
            while(hasNextChar() && json.charAt(parseIndex) != '}') {
                parseIndex++;
                StringBuilder nameBuilder = new StringBuilder();
                StringBuilder valueBuilder = new StringBuilder();

                parseName(nameBuilder);

                if(hasNextChar() && json.charAt(parseIndex) == ':' && json.charAt(parseIndex + 1) == '{') {
                    parseIndex += 2;
                    ADJsonSubCategory subCategory = new ADJsonSubCategory(nameBuilder.toString());

                    while (hasNextChar() && json.charAt(parseIndex) != '}') {
                        StringBuilder subNameBuilder = new StringBuilder();
                        StringBuilder subValueBuilder = new StringBuilder();

                        parseName(subNameBuilder);
                        parseValue(subValueBuilder);
                        subCategory.addEntry(new ADJsonConfigEntry(subNameBuilder.toString(),
                                subValueBuilder.toString()));
                        parseIndex++;
                    }
                    category.addSubCategory(subCategory);
                } else {
                    parseValue(valueBuilder);
                    category.addEntry(new ADJsonConfigEntry(nameBuilder.toString(), valueBuilder.toString()));
                }
            }
            categories.add(category);
            parseIndex++;
        }
        return categories;
    }

    private void parseName(StringBuilder nameBuilder) {
        while (hasNextChar() && json.charAt(parseIndex) != ':') {
            parseString(nameBuilder);
            parseIndex++;
        }
    }

    private void parseValue(StringBuilder valueBuilder) {
        if(json.charAt(parseIndex) == ':') {
            parseIndex++;

            if(json.charAt(parseIndex) == '"') {
                parseString(valueBuilder);
            } else {
                do {
                    valueBuilder.append(json.charAt(parseIndex));
                    parseIndex++;
                } while (hasNextChar() && json.charAt(parseIndex) != ',' && json.charAt(parseIndex) != '}');
            }
        }
    }

    private void parseString(StringBuilder builder) {
        if(json.charAt(parseIndex) == '"') {
            parseIndex++;
            while (hasNextChar() && json.charAt(parseIndex) != '"') {
                builder.append(json.charAt(parseIndex));
                parseIndex++;
            }
        }
    }

    private boolean hasNextChar() {
        return (parseIndex + 1) < json.length();
    }

    private static String removeWhitespace(String json) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);

            // Keep the quotes and spaces within strings
            if(c == '"') {
                do {
                    builder.append(json.charAt(i));
                    i++;
                    c = json.charAt(i);
                } while (c != '"');
            }

            if(!Character.isWhitespace(c)) {
                builder.append(json.charAt(i));
            }
        }
        return builder.toString();
    }
}
