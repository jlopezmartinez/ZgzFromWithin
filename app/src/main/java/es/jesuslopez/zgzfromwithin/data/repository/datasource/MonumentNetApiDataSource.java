package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import es.jesuslopez.zgzfromwithin.data.net.NetApi;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MonumentNetApiDataSource implements Datasource {
    private final NetApi netApi;

    public MonumentNetApiDataSource(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public Observable<ResponseMonumentEntity> listMonumentEntity(int from, int limit) {
        return netApi.monumentListEntity(from, limit);
    }

    @Override
    public Observable<ResponseRestaurantEntity> lisRestaurantEntity(int from, int limit) {
        return null;
    }
}
