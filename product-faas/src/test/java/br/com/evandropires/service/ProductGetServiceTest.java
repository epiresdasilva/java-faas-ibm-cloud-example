package br.com.evandropires.service;

import br.com.evandropires.document.ProductDocument;
import br.com.evandropires.exception.ApplicationException;
import br.com.evandropires.repository.Findable;
import br.com.evandropires.repository.Insertable;
import com.cloudant.client.api.model.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

/**
 * Created by evandro on 18/05/18.
 */
@RunWith(JUnit4.class)
public class ProductGetServiceTest {

    private class ProductFindRepository implements Findable {
        @Override
        public JsonObject find(String id) {
            if ("1".equals(id)) {
                return null;
            }

            JsonObject product = new JsonObject();
            product.addProperty("id", id);
            product.addProperty("description", "Product " + id);
            return product;
        }
    }

    @Test
    public void execute() throws ApplicationException {
        JsonObject productJsonPayload = new JsonObject();
        String id = "2";
        productJsonPayload.addProperty("id", id);

        JsonObject product = new ProductGetService(new ProductFindRepository()).execute(productJsonPayload);
        Assert.assertEquals(productJsonPayload.get("id").getAsString(),product.get("id").getAsString());
        Assert.assertEquals("Product " + id,product.get("description").getAsString());
    }

    @Test(expected = ApplicationException.class)
    public void executeWithoutId() throws ApplicationException {
        JsonObject productJsonPayload = new JsonObject();

        JsonObject product = new ProductGetService(new ProductFindRepository()).execute(productJsonPayload);
        Assert.assertNull(product);
    }

    @Test
    public void executeNotExists() throws ApplicationException {
        JsonObject productJsonPayload = new JsonObject();
        productJsonPayload.addProperty("id", "1");

        JsonObject product = new ProductGetService(new ProductFindRepository()).execute(productJsonPayload);
        Assert.assertNull(product);
    }

}
