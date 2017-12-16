package es.jesuslopez.zgzfromwithin.data.repository;

import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.Datasource;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.PlaceDataSourceFactory;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.MapperMonumentToMonumentEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Monument;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class MonumentRepository implements Repository {

    private final Datasource datasource;
    private final MapperMonumentToMonumentEntity mapperMonumentToMonumentEntity;

    @Inject
    public MonumentRepository(PlaceDataSourceFactory placeDataSourceFactory, MapperMonumentToMonumentEntity mapper) {
        this.datasource = placeDataSourceFactory.getMonumentDataSource();
        this.mapperMonumentToMonumentEntity = mapper;
    }

    @Override
    public Observable<List<Monument>> monumentList(int from, int limit) {
        return datasource.listMonumentEntity(from, limit).map(new Function<ResponseMonumentEntity, List<Monument>>() {

            @Override
            public List<Monument> apply(ResponseMonumentEntity responseEntity) throws Exception {
                return mapperMonumentToMonumentEntity.map(responseEntity.getResult());
            }
        });
    }

    @Override
    public Observable restaurantList(int from, int limit) {
        return null;
    }
}
