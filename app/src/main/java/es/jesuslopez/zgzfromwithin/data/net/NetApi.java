package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public interface NetApi {
    Observable<ResponseEntity> placeListEntity(int from, int limit);
}
