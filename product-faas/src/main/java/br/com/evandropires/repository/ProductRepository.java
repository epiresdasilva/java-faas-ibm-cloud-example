package br.com.evandropires.repository;

import br.com.evandropires.cloudant.CloudantCredentials;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.InputStreamReader;

/**
 * Created by evandro on 15/05/18.
 */
public class ProductRepository implements Insertable, Updatable, Deleteble, Findable {

    public JsonObject find(String id) {
        Database database = getCloudantClient().database("product", false);
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(database.find(id)));
        return gson.fromJson(reader, JsonObject.class);
    }

    public Response delete(Object object) {
        Database database = getCloudantClient().database("product", false);
        return database.remove(object);
    }

    public Response update(Object object) {
        Database database = getCloudantClient().database("product", false);
        return database.update(object);
    }

    public Response insert(Object object) {
        Database database = getCloudantClient().database("product", false);
        return database.save(object);
    }

    private CloudantClient getCloudantClient() {
        return ClientBuilder.bluemix(new CloudantCredentials().getCredentials())
                .build();
    }
}
