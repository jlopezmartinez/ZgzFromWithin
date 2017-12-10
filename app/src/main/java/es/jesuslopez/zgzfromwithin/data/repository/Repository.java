package es.jesuslopez.zgzfromwithin.data.repository;

import io.reactivex.Observable;

/**
 * Created by JesusLopez on 2/7/17.
 */

public interface Repository {
    Observable placeList(int from, int limit);

}
