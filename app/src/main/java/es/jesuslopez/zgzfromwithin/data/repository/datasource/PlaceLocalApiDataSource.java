package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class PlaceLocalApiDataSource implements Datasource {
    @Override
    public Observable<ResponseEntity> listPlaceEntity(int from, int limit) {
        return null;
    }
/*    private final LocalApi localApi;

    public PlaceLocalApiDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<List<PlaceEntity>> listPlaceEntity() {
        return localApi.placeListEntity();
    }*/
}
