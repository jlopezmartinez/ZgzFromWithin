package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

import static es.jesuslopez.zgzfromwithin.ZfwApplication.currentIndexPagination;

/**
 * Created by JesusLopez on 18/7/17.
 */

public class NetImpl implements NetApi {

    @Override
    public Observable<ResponseEntity> placeListEntity() {
        return ServiceGenerator.getPlacesService().getListPlaces(10, currentIndexPagination);
    }
}
