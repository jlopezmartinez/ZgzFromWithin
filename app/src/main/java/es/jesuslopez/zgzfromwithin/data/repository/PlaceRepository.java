package es.jesuslopez.zgzfromwithin.data.repository;

import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.PlaceDataSourceFactory;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Datasource;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.MapperPlaceToPlaceEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Place;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class PlaceRepository implements Repository {

    private final Datasource datasource;
    private final MapperPlaceToPlaceEntity mapperPlaceToPlaceEntity;

    @Inject
    public PlaceRepository(PlaceDataSourceFactory placeDataSourceFactory, MapperPlaceToPlaceEntity mapper) {
        this.datasource = placeDataSourceFactory.getDataSource();
        this.mapperPlaceToPlaceEntity = mapper;
    }

    @Override
    public Observable<List<Place>> placeList() {
        return datasource.listPlaceEntity().map(new Function<List<PlaceEntity>, List<Place>>() {
            @Override
            public List<Place> apply(List<PlaceEntity> placeEntities) throws Exception {
                return mapperPlaceToPlaceEntity.map(placeEntities);
            }
        });
    }
}
