package es.jesuslopez.zgzfromwithin.data.repository;

import java.util.List;

import es.jesuslopez.zgzfromwithin.domain.model.Place;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class PlaceRepository implements Repository {
    @Override
    public Observable<List<Place>> placeList() {
        return null;
    }
}
