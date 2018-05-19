package br.com.evandropires.function;

import br.com.evandropires.exception.ApplicationException;
import br.com.evandropires.repository.ProductRepository;
import br.com.evandropires.service.ProductGetService;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 26/04/18.
 */
public class ProductGetFunction {

    public static JsonObject main(JsonObject tipoAvaliacao) throws ApplicationException {
        return new ProductGetService(new ProductRepository()).execute(tipoAvaliacao);
    }

}