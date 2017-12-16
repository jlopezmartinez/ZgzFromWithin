package es.jesuslopez.zgzfromwithin.data.repository;

import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.Datasource;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.PlaceDataSourceFactory;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.MapperRestaurantToRestaurantEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Restaurant;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class RestaurantRepository implements Repository {

    private final Datasource datasource;
    private final MapperRestaurantToRestaurantEntity mapperRestaurantToRestaurantEntity;

    @Inject
    public RestaurantRepository(PlaceDataSourceFactory placeDataSourceFactory, MapperRestaurantToRestaurantEntity mapper) {
        this.datasource = placeDataSourceFactory.getRestaurantDataSource();
        this.mapperRestaurantToRestaurantEntity = mapper;
    }

    @Override
    public Observable monumentList(int from, int limit) {
        return null;
    }

    @Override
    public Observable restaurantList(int from, int limit) {
        return datasource.lisRestaurantEntity(from, limit).map(new Function<ResponseRestaurantEntity, List<Restaurant>>() {

            @Override
            public List<Restaurant> apply(ResponseRestaurantEntity responseEntity) throws Exception {
                return mapperRestaurantToRestaurantEntity.map(responseEntity.getResult());
            }
        });
    }
}
