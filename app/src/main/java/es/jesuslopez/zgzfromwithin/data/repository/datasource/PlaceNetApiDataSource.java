package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import es.jesuslopez.zgzfromwithin.data.net.NetApi;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class PlaceNetApiDataSource implements Datasource {
    private final NetApi netApi;

    public PlaceNetApiDataSource(NetApi netApi) {
        this.netApi = netApi;
    }

    @Override
    public Observable<ResponseEntity> listPlaceEntity(int from, int limit ) {
        return netApi.placeListEntity(from, limit);
    }
}
