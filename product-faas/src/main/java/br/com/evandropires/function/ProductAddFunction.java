package br.com.evandropires.function;

import br.com.evandropires.exception.ApplicationException;
import br.com.evandropires.repository.ProductRepository;
import br.com.evandropires.service.ProductAddService;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 26/04/18.
 */
public class ProductAddFunction {

    public static JsonObject main(JsonObject tipoAvaliacao) throws ApplicationException {
        return new ProductAddService(new ProductRepository()).execute(tipoAvaliacao);
    }

}