package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.local.LocalImpl;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.JSONMapperPlaceEntity;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class PlaceDataSourceFactory {

    private final Context context;

    @Inject
    public PlaceDataSourceFactory(Context ctx) {
        this.context = ctx;
    }

    public PlaceLocalApiDataSource getDataSource() {
        JSONMapperPlaceEntity jsonMapperPlaceEntity = new JSONMapperPlaceEntity();
        LocalImpl local = new LocalImpl(context, jsonMapperPlaceEntity);
        return new PlaceLocalApiDataSource(local);
    }
}
