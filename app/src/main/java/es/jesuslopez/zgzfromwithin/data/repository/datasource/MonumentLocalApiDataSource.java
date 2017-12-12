package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MonumentLocalApiDataSource implements Datasource {
    @Override
    public Observable<ResponseEntity> listPlaceEntity(int from, int limit) {
        return null;
    }
/*    private final LocalApi localApi;

    public MonumentLocalApiDataSource(LocalApi localApi) {
        this.localApi = localApi;
    }

    @Override
    public Observable<List<MonumentEntity>> listMonumentEntity() {
        return localApi.monumentListEntity();
    }*/
}
