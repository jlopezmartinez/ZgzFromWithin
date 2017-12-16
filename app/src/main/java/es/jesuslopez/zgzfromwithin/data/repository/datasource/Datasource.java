package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 11/7/17.
 */

public interface Datasource {
    Observable<ResponseMonumentEntity> listMonumentEntity(int from, int limit);

    Observable<ResponseRestaurantEntity> lisRestaurantEntity(int from, int limit);
}
