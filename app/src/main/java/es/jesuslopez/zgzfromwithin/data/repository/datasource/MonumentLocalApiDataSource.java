package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MonumentLocalApiDataSource implements Datasource {

    @Override
    public Observable<ResponseMonumentEntity> listMonumentEntity(int from, int limit) {
        return null;
    }

    @Override
    public Observable<ResponseRestaurantEntity> lisRestaurantEntity(int from, int limit) {
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
