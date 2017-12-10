package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 11/7/17.
 */

public interface Datasource {
    Observable<ResponseEntity> listPlaceEntity(int from, int limit);
}
