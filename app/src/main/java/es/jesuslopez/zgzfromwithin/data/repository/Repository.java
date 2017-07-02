package es.jesuslopez.zgzfromwithin.data.repository;

import java.util.List;

import io.reactivex.Observable;

import es.jesuslopez.zgzfromwithin.domain.model.Place;

/**
 * Created by JesusLopez on 2/7/17.
 */

public interface Repository {
    Observable<List<Place>> placeList();

}
