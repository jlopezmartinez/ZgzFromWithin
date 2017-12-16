package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 18/7/17.
 */

public class NetImpl implements NetApi {

    @Override
    public Observable<ResponseMonumentEntity> monumentListEntity(int from, int limit) {
        return ServiceGenerator.getPlacesService().getListMonuments(limit, from);
    }

    @Override
    public Observable<ResponseRestaurantEntity> restaurantListEntity(int from, int limit) {
        return ServiceGenerator.getPlacesService().getListRestaurants(limit, from);
    }
}
