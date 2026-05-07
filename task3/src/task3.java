import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) {
        String valuesPath = args[0];
        String testsPath = args[1];
        String reportPath = args[2];
        ObjectMapper mapper = new ObjectMapper();
        try {
                JsonNode values1 = mapper.readTree(new File(valuesPath));
                ArrayNode values = (ArrayNode) values1.get("values");
                JsonNode tests1 = mapper.readTree(new File(testsPath));
                ArrayNode tests = (ArrayNode) tests1.get("tests");
                getReport(tests,values);
                mapper.writeValue(new File(reportPath),tests);
        }catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public static void getReport (ArrayNode tests, ArrayNode values){
        for (JsonNode currentTest: tests) {
            for (JsonNode value: values) {
                if ((currentTest.get("id").equals(value.get("id")))&& (currentTest.hasNonNull("value"))){
                    ((ObjectNode)currentTest).put("value",value.get("value"));
                }
            }
            if (currentTest.hasNonNull("values")){
                ArrayNode testValues = (ArrayNode) currentTest.get("values");
                getReport(testValues,values);
            }
            System.out.println(currentTest);
        }
    }
}
