package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 18/7/17.
 */

public class NetImpl implements NetApi {

    @Override
    public Observable<ResponseEntity> placeListEntity(int from, int limit) {
        return ServiceGenerator.getPlacesService().getListPlaces(limit, from);
    }
}
