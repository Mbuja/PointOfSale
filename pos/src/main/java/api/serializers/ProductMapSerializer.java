package api.serializers;

import com.google.gson.*;

import point.of.sale.Product;

import java.lang.reflect.Type;
import java.util.Map;

public class ProductMapSerializer implements JsonSerializer<Map<Product, Integer>> {
    @Override
    public JsonElement serialize(Map<Product, Integer> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray array = new JsonArray();

        for (Map.Entry<Product, Integer> entry : src.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            JsonObject obj = new JsonObject();
            obj.addProperty("id", product.getId()); // Ensure Product has a getId method
            obj.addProperty("name", product.getName()); // Ensure Product has a getName method
            obj.addProperty("price", product.getPrice()); // Ensure Product has a getPrice method
            obj.addProperty("quantity", quantity);

            array.add(obj);
        }

        return array;
    }
}
