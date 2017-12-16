package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public interface NetApi {
    Observable<ResponseRestaurantEntity> restaurantListEntity(int from, int limit);
    Observable<ResponseMonumentEntity> monumentListEntity(int from, int limit);
}
