package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import java.util.List;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 11/7/17.
 */

public interface Datasource {
    Observable<List<PlaceEntity>> listPlaceEntity();
}
