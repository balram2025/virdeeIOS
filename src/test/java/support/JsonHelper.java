package support;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static support.World.jsonHelper;

public class JsonHelper {

    private final String mockAdminJson = "data/mockAdmin.json";
    private final String featureUIJson = "data/featureUITranslations.json";

    // Reading the JSON file
    public JSONObject jsonFileReader(String jsonFilePath) throws Exception {
        // JSON parser object
        JSONParser jsonParser = new JSONParser();
        // Read the JSON file
        FileReader reader = new FileReader(jsonFilePath);
        // Read and parse the JSON object
        JSONObject json = (JSONObject) jsonParser.parse(reader);
        return json;
    }


    // Reading the mock admin payloads
    public JSONObject getMockAdminJsonPayload(String keyName) throws Exception {
        JSONObject json = jsonHelper.jsonFileReader(mockAdminJson);
        // Get the key value
        JSONObject payLoad = (JSONObject) json.get(keyName);
        return payLoad;
    }


    public JSONObject getFeatureUIJson(String keyName) throws Exception {
        JSONObject json = jsonHelper.jsonFileReader(featureUIJson);
        JSONObject payLoad = (JSONObject) json.get(keyName);
        return payLoad;
    }

    public String getValueFromKey(JSONObject jsonData, String keyName) {
        String value = (String) jsonData.get(keyName);
        return value;
    }


}
