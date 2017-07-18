package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

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

    public List<PlaceEntity> getListPlacesEntityFromJSON(String response) throws JsonSyntaxException {
        try {
            Type type = new TypeToken<List<PlaceEntity>>() {
            }.getType();
            return gson.fromJson(response, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
