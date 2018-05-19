package br.com.evandropires.service;

import br.com.evandropires.exception.ApplicationException;
import br.com.evandropires.repository.Findable;
import br.com.evandropires.repository.ProductRepository;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 27/04/18.
 */
public class ProductGetService {

    private Findable findable;

    public ProductGetService(Findable findable) {
        this.findable = findable;
    }

    public JsonObject execute(JsonObject productJson) throws ApplicationException {
        if (!productJson.has("id")) {
            throw new ApplicationException("id is mandatory.");
        }

        String id = productJson.get("id").getAsString();

        JsonObject jsonResponse = findable.find(id);
        return jsonResponse;
    }
}
