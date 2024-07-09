package rndm_access.assorteddiscoveries.config.json;

import java.util.LinkedList;
import java.util.List;

public class ADJsonParser {
    private final LinkedList<String> json;
    private int column;
    private int line;
    private int depth; // TODO: Add exceptions for when there are missing curly braces using this!
    private char token;

    public ADJsonParser(List<String> json) {
        this.json = stripWhitespaceAndComments(json);
        column = 0;
        line = 1;
        depth = 0;
        token = this.json.get(0).charAt(0);
    }

    public LinkedList<ADJsonConfigCategory> parseJsonFile() {
        LinkedList<ADJsonConfigCategory> categories = new LinkedList<>();

        while (hasNextToken()) {
            StringBuilder categoryNameBuilder = new StringBuilder();
            parseString(categoryNameBuilder);

            if (token == ':') {
                consumeToken();
                if (token == '{') {
                    consumeToken();
                    depth++;
                    ADJsonConfigCategory.Builder category = new ADJsonConfigCategory
                            .Builder(categoryNameBuilder.toString());

                    parseComponent(category, null);
                    categories.add(category.build());
                }
            }
            consumeToken();
        }
        return categories;
    }

    private void parseComponent(ADJsonConfigCategory.Builder categoryBuilder,
                                ADJsonConfigCategory.Builder subCategoryBuilder) {
        while (hasNextToken() && token != ',' && token != '}') {
            StringBuilder keyNameBuilder = new StringBuilder();
            parseString(keyNameBuilder);

            if (token == ':') {
                consumeToken();
                if (token == '{') {
                    consumeToken();
                    ADJsonConfigCategory.Builder tempCategoryBuilder = new ADJsonConfigCategory
                            .Builder(keyNameBuilder.toString());
                    depth++;

                    if(subCategoryBuilder != null) {
                        parseComponent(subCategoryBuilder, tempCategoryBuilder);
                    } else {
                        parseComponent(categoryBuilder, tempCategoryBuilder);
                    }
                } else {
                    String value = parseValue();
                    ADJsonConfigEntry entry = new ADJsonConfigEntry(keyNameBuilder.toString(), value);

                    if (subCategoryBuilder != null) {
                        subCategoryBuilder.addEntry(entry);
                    } else {
                        categoryBuilder.addEntry(entry);
                    }
                }

                if(token == '}') {
                    depth--;
                }
            }
            consumeToken();
        }

        if(subCategoryBuilder != null) {
            categoryBuilder.addSubcategory(subCategoryBuilder.build());
        }
    }

    private String parseValue() {
        StringBuilder valueBuilder = new StringBuilder();

        if (token == '"') {
            parseString(valueBuilder);
        } else {
            do {
                valueBuilder.append(token);
                consumeToken();
            } while (hasNextToken() && token != ',' && token != '}');
        }
        return valueBuilder.toString();
    }

    private void parseString(StringBuilder builder) {
        if (token == '"') {
            consumeToken();

            while (hasNextToken() && token != '"') {
                builder.append(token);
                consumeToken();
            }
            consumeToken();
        }
    }

    private boolean hasNextToken() {
        if(line == json.size()) {
            return column < json.get(line - 1).length();
        }
        return line < json.size();
    }

    private void consumeToken() {
        String jsonLine = json.get(line - 1);
        column++;

        if (column < jsonLine.length()) {
            token = jsonLine.charAt(column);
        } else {
            if(line < json.size()) {
                line++;
                column = 0;
                jsonLine = json.get(line - 1);
                token = jsonLine.charAt(column);
            }
        }
    }

    private static LinkedList<String> stripWhitespaceAndComments(List<String> jsonFileLines) {
        LinkedList<String> jsonLines = new LinkedList<>();

        for (String jsonFileLine : jsonFileLines) {
            StringBuilder jsonLine = new StringBuilder();

            for (int i = 0; i < jsonFileLine.length(); i++) {
                char token = jsonFileLine.charAt(i);

                // Keep the quotes and spaces within strings!
                if (token == '"') {
                    do {
                        jsonLine.append(jsonFileLine.charAt(i));
                        i++;
                        token = jsonFileLine.charAt(i);
                    } while (token != '"');
                }

                // Skip lines with comments!
                if (token == '/') {
                    i++;
                    token = jsonFileLine.charAt(i);

                    if (token == '/') {
                        break;
                    }
                }

                if (!Character.isWhitespace(token)) {
                    jsonLine.append(jsonFileLine.charAt(i));
                }
            }

            // The comments are skipped, so they're empty lines,
            // and we do not need to add them to the line list!
            if(!jsonLine.isEmpty()) {
                jsonLines.add(jsonLine.toString());
            }
        }
        return jsonLines;
    }
}
