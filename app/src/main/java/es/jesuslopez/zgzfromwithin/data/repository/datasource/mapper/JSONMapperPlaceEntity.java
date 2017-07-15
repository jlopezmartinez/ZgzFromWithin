package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class JSONMapperPlaceEntity {

    private final Gson gson;

    @Inject
    public JSONMapperPlaceEntity() {
        gson = new Gson();
    }

    public PlaceEntity getPlaceEntityFromJSON(String response) throws JsonSyntaxException {
        try {
            Type type = new TypeToken<PlaceEntity>() {
            }.getType();

            PlaceEntity placeEntity = gson.fromJson(response, type);
            return placeEntity;
        } catch (JsonSyntaxException exception) {
            exception.printStackTrace();
            throw exception;
        }
    }
}
