package es.jesuslopez.zgzfromwithin.data.repository;

import io.reactivex.Observable;

/**
 * Created by JesusLopez on 2/7/17.
 */

public interface Repository {
    Observable monumentList(int from, int limit);
    Observable restaurantList(int from, int limit);
}
