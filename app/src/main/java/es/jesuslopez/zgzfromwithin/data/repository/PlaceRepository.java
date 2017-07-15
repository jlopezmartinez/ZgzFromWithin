package es.jesuslopez.zgzfromwithin.data.repository;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Datasource;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.MapperPlaceToPlaceEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Place;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class PlaceRepository implements Repository {

    private final Datasource datasource;
    private final MapperPlaceToPlaceEntity mapperPlaceToPlaceEntity;

    @Inject public PlaceRepository()
    @Override
    public Observable<List<Place>> placeList() {
        return null;
    }
}
