package rndm_access.assorteddiscoveries.config.json;

import java.util.LinkedList;
import java.util.List;

public class JsonParser {
    private final LinkedList<String> json;
    private int column;
    private int line;
    private char token;

    public JsonParser(List<String> json) {
        this.json = stripWhitespace(json);
        column = 0;
        line = 0;
        token = this.json.get(0).charAt(0);
    }

    public LinkedList<JsonConfigCategory> parseJsonFile() {
        LinkedList<JsonConfigCategory> categories = new LinkedList<>();

        while (hasNextToken()) {
            StringBuilder categoryNameBuilder = new StringBuilder();

            if(token == '"') {
                parseString(categoryNameBuilder);

                if (require(':')) {
                    consumeToken();
                    if (require('{')) {
                        consumeToken();
                        JsonConfigCategory.Builder category = new JsonConfigCategory
                                .Builder(categoryNameBuilder.toString());

                        parseJsonObject(category, null);
                        categories.add(category.build());
                    }
                }
            }
            consumeToken();
        }
        return categories;
    }

    private void parseJsonObject(JsonConfigCategory.Builder categoryBuilder,
                                 JsonConfigCategory.Builder subCategoryBuilder) {
        while (hasNextToken() && token != ',' && token != '}') {
            this.skipComment();
            StringBuilder keyNameBuilder = new StringBuilder();
            parseString(keyNameBuilder);

            if (require(':')) {
                consumeToken();
                if (token == '{') {
                    require('{');
                    consumeToken();
                    JsonConfigCategory.Builder tempCategoryBuilder = new JsonConfigCategory
                            .Builder(keyNameBuilder.toString());

                    if(subCategoryBuilder != null) {
                        parseJsonObject(subCategoryBuilder, tempCategoryBuilder);
                    } else {
                        parseJsonObject(categoryBuilder, tempCategoryBuilder);
                    }
                } else {
                    String value = parseValue();
                    JsonConfigEntry entry = new JsonConfigEntry(keyNameBuilder.toString(), value);

                    if (subCategoryBuilder != null) {
                        subCategoryBuilder.addEntry(entry);
                    } else {
                        categoryBuilder.addEntry(entry);
                    }
                }
            }

            if(this.token != '}') {
                require(',');
                consumeToken();
            } else {
                require('}');
                consumeToken();

                if((line + 1) == json.size()) {
                    require('}');
                } else {
                    require(',');
                }
            }
        }

        if(subCategoryBuilder != null) {
            categoryBuilder.addSubcategory(subCategoryBuilder.build());
        }
    }

    private void skipComment() {
        if (token == '/') {
            consumeToken();

            if (token == '/') {
                consumeToken();
                advanceLine();
            }
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
            } while (hasNextToken() && isNotSpecialCharacter());
        }
        return valueBuilder.toString();
    }

    private void parseString(StringBuilder builder) {
        if (token == '"') {
            require('"');
            consumeToken();

            while (hasNextToken() && isNotSpecialCharacter()) {
                builder.append(token);
                consumeToken();
            }
            require('"');
            consumeToken();
        }
    }

    private boolean hasNextToken() {
        if((line + 1) == json.size()) {
            return column < json.get(line).length();
        }
        return line < json.size();
    }

    private boolean require(char token) {
        if(this.token != token) {
            throw new JsonSyntaxException("Expected " + token
                    + " but found " + this.token
                    + " at line " + (this.line + 1)
                    + " and column " + (this.column + 1));
        }
        return true;
    }

    private void consumeToken() {
        String jsonLine = json.get(line);
        column++;

        if (column < jsonLine.length()) {
            token = jsonLine.charAt(column);
        } else {
            if(line < json.size() - 1) {
                advanceLine();
            }
        }
    }

    private void advanceLine() {
        line++;
        column = 0;
        String jsonLine = json.get(line);
        token = jsonLine.charAt(column);
    }

    private boolean isNotSpecialCharacter() {
        return token != '"' && token != ':' && token != ','
                && token != '{' && token != '}'
                && token != '[' && token != ']';
    }

    private static LinkedList<String> stripWhitespace(List<String> jsonFileLines) {
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
                    } while (token != '"' && token != ':' && token != ','
                            && token != '{' && token != '}'
                            && token != '[' && token != ']');
                }

                if (!Character.isWhitespace(token)) {
                    jsonLine.append(jsonFileLine.charAt(i));
                }
            }

            // The comments are skipped, so they're empty lines,
            // and we do not need to add them to the line list!
            if(!jsonLine.isEmpty()) {
                //jsonLine.append('\n');
                jsonLines.add(jsonLine.toString());
            }
        }
        return jsonLines;
    }
}
