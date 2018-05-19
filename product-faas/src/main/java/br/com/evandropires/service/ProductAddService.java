package br.com.evandropires.service;

import br.com.evandropires.cloudant.CloudantCredentials;
import br.com.evandropires.document.ProductDocument;
import br.com.evandropires.exception.ApplicationException;
import br.com.evandropires.repository.Insertable;
import br.com.evandropires.repository.ProductRepository;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 27/04/18.
 */
public class ProductAddService {

    private Insertable insertable;

    public ProductAddService(Insertable insertable) {
        this.insertable = insertable;
    }

    public JsonObject execute(JsonObject productJson) throws ApplicationException {
        if (!productJson.has("description")) {
            throw new ApplicationException("Description is mandatory.");
        }

        ProductDocument productDocument = new ProductDocument();
        productDocument.setDescription(productJson.getAsJsonPrimitive("description").getAsString());

        Response response = insertable.insert(productDocument);

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("id", response.getId());
        return jsonResponse;
    }
}
