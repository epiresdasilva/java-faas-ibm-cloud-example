package br.com.evandropires.repository;

import com.google.gson.JsonObject;

/**
 * Created by evandro on 16/05/18.
 */
public interface Findable {

    JsonObject find(String id);

}
