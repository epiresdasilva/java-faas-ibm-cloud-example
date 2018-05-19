package br.com.evandropires.cloudant;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 * Created by evandro on 26/04/18.
 */
public class CloudantCredentials {

    private static final Logger LOGGER = Logger.getLogger(CloudantCredentials.class.getName());

    private String credentials;

    public CloudantCredentials() {
        this(CloudantCredentials.class.getResourceAsStream("/cloudant.json"));
    }

    public CloudantCredentials(InputStream cloudantCredentialsFile) {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(cloudantCredentialsFile));
        this.credentials = gson.fromJson(reader, JsonObject.class).toString();
    }

    public String getCredentials() {
        return credentials;
    }

}
