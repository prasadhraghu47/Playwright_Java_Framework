package Utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.util.Map;

public class JsonDataUtils {
    public static JsonObject getTestData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return new Gson().fromJson(reader, JsonObject.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data", e);
        }
    }


    public static Map<String, Object> loadJson(String filePath) throws Exception {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(filePath), Map.class);
    }
}
