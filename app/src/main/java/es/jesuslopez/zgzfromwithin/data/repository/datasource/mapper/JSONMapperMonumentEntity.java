package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.MonumentEntity;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class JSONMapperMonumentEntity {

    private final Gson gson;

    @Inject
    public JSONMapperMonumentEntity() {
        gson = new Gson();
    }

    public List<MonumentEntity> getListMonumentsEntityFromJSON(String response) throws JsonSyntaxException {
        try {
            Type type = new TypeToken<List<MonumentEntity>>() {
            }.getType();
            return gson.fromJson(response, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
