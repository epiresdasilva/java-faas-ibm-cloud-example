package br.com.evandropires.service;

import br.com.evandropires.document.ProductDocument;
import br.com.evandropires.exception.ApplicationException;
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
public class ProductAddServiceTest {

    private class ResponseTest extends Response {

        private String id;

        public ResponseTest(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }
    }

    private class ProductInsertRepository implements Insertable {
        @Override
        public Response insert(Object object) {
            ResponseTest responseTest = new ResponseTest("" + new Random().nextInt(1000));
            return responseTest;
        }
    }

    @Test
    public void execute() throws ApplicationException {
        ProductDocument productDocument = new ProductDocument();
        productDocument.setDescription("Product one");

        Gson gson = new Gson();
        String json = gson.toJson(productDocument);
        JsonObject productJsonPayload = gson.fromJson(json, JsonObject.class);

        JsonObject product = new ProductAddService(new ProductInsertRepository()).execute(productJsonPayload);
        Assert.assertTrue(product.get("id").getAsInt() > 0);
    }

    @Test(expected = ApplicationException.class)
    public void executeWithoutDescription() throws ApplicationException {
        ProductDocument productDocument = new ProductDocument();

        Gson gson = new Gson();
        String json = gson.toJson(productDocument);
        JsonObject productJsonPayload = gson.fromJson(json, JsonObject.class);

        JsonObject product = new ProductAddService(new ProductInsertRepository()).execute(productJsonPayload);
        Assert.assertTrue(product.get("id").getAsInt() > 0);
    }

}
