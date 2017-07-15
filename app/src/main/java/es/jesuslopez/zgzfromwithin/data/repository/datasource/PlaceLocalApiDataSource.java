package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import java.util.List;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;
import es.jesuslopez.zgzfromwithin.data.local.LocalApi;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Datasource;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class PlaceLocalApiDataSource implements Datasource {
    private final LocalApi localApi;

    public PlaceLocalApiDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<List<PlaceEntity>> listPlaceEntity() {
        return localApi.placeListEntity();
    }
}
