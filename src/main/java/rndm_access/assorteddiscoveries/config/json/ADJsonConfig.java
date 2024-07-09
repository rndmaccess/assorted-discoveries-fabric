package rndm_access.assorteddiscoveries.config.json;

import java.util.Collection;
import java.util.LinkedHashMap;

public class ADJsonConfig {
    public LinkedHashMap<String, ADJsonConfigCategory> nameToCategories;

    protected ADJsonConfig(Builder builder) {
        this.nameToCategories = builder.configCategories;
    }

    public ADJsonConfigCategory getCategory(String categoryName) {
        if(!this.hasCategory(categoryName)) {
            throw new RuntimeException("The config does not have category " + categoryName);
        }
        return nameToCategories.get(categoryName);
    }

    public boolean hasCategory(String categoryName) {
        return nameToCategories.containsKey(categoryName);
    }

    public Collection<ADJsonConfigCategory> getCategories() {
        return nameToCategories.values();
    }

    public String toJson() {
        StringBuilder builder = new StringBuilder();

        if (!this.getCategories().isEmpty()) {
            builder.append('{');

            int indent = 1;
            int i = 0;
            for (ADJsonConfigCategory category : this.getCategories()) {
                builder.append('\n');
                writeCategories(category, builder, indent);

                if(i + 1 < this.getCategories().size()) {
                    builder.append(',');
                }
                i++;
            }
            builder.append('\n');
            builder.append('}');
        }
        return builder.toString();
    }

    private void writeCategories(ADJsonConfigCategory category, StringBuilder builder, int depth) {
        indent(builder, depth);
        depth++;
        builder.append('\"');
        builder.append(category.getName());
        builder.append('\"');
        builder.append(": {");
        builder.append('\n');

        for (int i = 0; i < category.getComponents().size(); i++) {
            ADJsonConfigComponent component = category.getComponents().get(i);

            if (category.hasEntry(component.getName())) {
                ADJsonConfigEntry entry = (ADJsonConfigEntry) component;

                if(entry.getComment() != null) {
                    writeComment(builder, entry, depth);
                }

                indent(builder, depth);
                builder.append('\"');
                builder.append(entry.getName());
                builder.append('\"');
                builder.append(": ");

                if(entry.getValue().getClass().equals(String.class)) {
                    builder.append('\"');
                    builder.append(entry.getValue());
                    builder.append('\"');
                } else {
                    builder.append(entry.getValue());
                }
            } else {
                ADJsonConfigCategory subCategory = category.getSubcategory(component.getName());
                writeCategories(subCategory, builder, depth);
            }

            if (i + 1 < category.getComponents().size()) {
                builder.append(',');
                builder.append('\n');
            } else {
                depth--;
                builder.append('\n');
                indent(builder, depth);
                builder.append('}');
            }
        }
    }

    private void writeComment(StringBuilder builder, ADJsonConfigEntry entry, int depth) {
        indent(builder, depth);
        builder.append("// ");

        for (int i = 0; i < entry.getComment().length(); i++) {
            char token = entry.getComment().charAt(i);

            if(token == '\n') {
                builder.append(token);
                indent(builder, depth);
                builder.append("// ");
            } else {
                builder.append(token);
            }
        }
        builder.append('\n');
    }

    private void indent(StringBuilder builder, int indent) {
        builder.append("\t".repeat(Math.max(0, indent)));
    }

    public static class Builder {
        public LinkedHashMap<String, ADJsonConfigCategory> configCategories = new LinkedHashMap<>();

        public Builder addCategory(ADJsonConfigCategory category) {
            configCategories.put(category.getName(), category);
            return this;
        }

        public ADJsonConfig build() {
            return new ADJsonConfig(this);
        }
    }
}
