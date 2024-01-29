package mockAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class JsonComparatorWithArray {

    public static void main(String[] args) {
        // Your unordered JSON responses as strings
        String json1 = "{\n" +
                "  \"dacKey\": \"C2010-0-48902-4\",\n" +
                "  \"title\": \"Divine Violence\",\n" +
                "  \"subtitle\": \"Walter Benjamin and the Eschatology of Sovereignty\",\n" +
                "  \"author\": [\n" +
                "    {\n" +
                "      \"firstname\": \"James\",\n" +
                "      \"name\": \"Martel\",\n" +
                "      \"sortorder\": 1,\n" +
                "      \"typename\": \"author\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"ownership\": \"UK\",\n" +
                "  \"seriesTitle\": \"\",\n" +
                "  \"edition\": 1,\n" +
                "  \"imprint\": \"Routledge\",\n" +
                "  \"division\": \"Law\",\n" +
                "  \"isbn\": \"9780203803264\",\n" +
                "  \"mastereIsbn\": \"9780203803264\",\n" +
                "  \"formatDoi\": \"10.4324/9780203803264\",\n" +
                "  \"versionType\": \"e-Book\",\n" +
                "  \"subGroup\": \"Monograph (DRM-Free)\",\n" +
                "  \"binding\": \"eBook - General\",\n" +
                "  \"pubDate\": \"2013-03-01 00:00:00\",\n" +
                "  \"firstPlannedPubDate\": \"2011-09-29 00:00:00\",\n" +
                "  \"status\": \"Available\",\n" +
                "  \"orderNumber\": \"YE16651\",\n" +
                "  \"pageExtent\": 168,\n" +
                "  \"trimSize\": \"ROY8:234 x 156 mm (6.14 x 9.21)\",\n" +
                "  \"isbnsUnderDac\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632556\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780415673457\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780203803264\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632563\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780415815246\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632518\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632501\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632532\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"digiformIsbnRecords\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632501\",\n" +
                "      \"cat_code\": \"DIGIFORMDXISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632556\",\n" +
                "      \"cat_code\": \"DIGIFORMEP3ISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632532\",\n" +
                "      \"cat_code\": \"DIGIFORMMSRISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632563\",\n" +
                "      \"cat_code\": \"DIGIFORMADBISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632518\",\n" +
                "      \"cat_code\": \"DIGIFORMMOBISBN\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"copyRightYear\": \"2012\",\n" +
                "  \"ctmRtr\": false,\n" +
                "  \"ctmRfm\": true\n" +
                "}";
        String json2 = "{\n" +
                "  \"dacKey\": \"C2010-0-48902-4\",\n" +
                "  \"title\": \"Divine Violence\",\n" +
                "  \"subtitle\": \"Walter Benjamin and the Eschatology of Sovereignty\",\n" +
                "  \"author\": [\n" +
                "    {\n" +
                "      \"firstname\": \"James\",\n" +
                "      \"name\": \"Martel\",\n" +
                "      \"sortorder\": 1,\n" +
                "      \"typename\": \"Author\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"ownership\": \"UK\",\n" +
                "  \"seriesTitle\": \"\",\n" +
                "  \"edition\": 1,\n" +
                "  \"imprint\": \"Routledge\",\n" +
                "  \"division\": \"Law\",\n" +
                "  \"isbn\": \"9780203803264\",\n" +
                "  \"mastereIsbn\": \"\",\n" +
                "  \"formatDoi\": \"10.4324/9780203803264\",\n" +
                "  \"versionType\": \"e-Book\",\n" +
                "  \"subGroup\": \"Monograph (DRM-Free)\",\n" +
                "  \"binding\": \"eBook - General\",\n" +
                "  \"pubDate\": \"2013-03-01 00:00:00\",\n" +
                "  \"firstPlannedPubDate\": \"2011-09-29 00:00:00\",\n" +
                "  \"status\": \"Available\",\n" +
                "  \"orderNumber\": \"YE16651\",\n" +
                "  \"pageExtent\": 168,\n" +
                "  \"trimSize\": \"ROY8:234 x 156 mm (6.14 x 9.21)\",\n" +
                "  \"isbnsUnderDac\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9780203803264\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780415671576\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780415673457\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9780415815246\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"digiformIsbnRecords\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632532\",\n" +
                "      \"cat_code\": \"DIGIFORMMSRISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632556\",\n" +
                "      \"cat_code\": \"DIGIFORMEP3ISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632518\",\n" +
                "      \"cat_code\": \"DIGIFORMMOBISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632563\",\n" +
                "      \"cat_code\": \"DIGIFORMADBISBN\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781136632501\",\n" +
                "      \"cat_code\": \"DIGIFORMDXISBN\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"copyRightYear\": \"2012\",\n" +
                "  \"ctmRtr\": true,\n" +
                "  \"ctmRfm\": true\n" +
                "}";

        try {
            // Parse JSON responses into ObjectNode
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode node1 = sortArrayInJsonNode(objectMapper.readTree(json1));
            ObjectNode node2 = sortArrayInJsonNode(objectMapper.readTree(json2));

            // Compare sorted JSON nodes
            boolean isEqual = node1.equals(node2);

            // Print the result
            System.out.println("Are the JSONs equal after sorting arrays? " + isEqual);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ObjectNode sortArrayInJsonNode(JsonNode jsonNode) {
        if (jsonNode.isObject()) {
            ObjectNode objectNode = (ObjectNode) jsonNode;
            Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                if (entry.getValue().isArray()) {
                    ArrayNode sortedArray = sortArray(entry.getValue());
                    objectNode.set(entry.getKey(), sortedArray);
                }
            }
            return objectNode;
        }
        return (ObjectNode) jsonNode;
    }

    private static ArrayNode sortArray(JsonNode arrayNode) {
        // Sort the array elements
        TreeMap<String, JsonNode> sortedElements = new TreeMap<>();
        arrayNode.elements().forEachRemaining(element -> sortedElements.put(element.toString(), element));



        // Create a new array with sorted elements
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode sortedArrayNode = objectMapper.createArrayNode();
        sortedElements.values().forEach(sortedArrayNode::add);

        return sortedArrayNode;
    }
}