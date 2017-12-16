package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseMonumentEntity;
import es.jesuslopez.zgzfromwithin.data.entity.ResponseRestaurantEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface PlacesService {
    @GET("monumento.json?")
    Observable<ResponseMonumentEntity> getListMonuments(@Query("rows") int rows, @Query("start") int start);

    @GET("restaurante.json?")
    Observable<ResponseRestaurantEntity> getListRestaurants(@Query("rows") int rows, @Query("start") int start);

    //@GET("alojamiento.json?")
    //Observable<ResponseEntity> getListAccomodations(@Query("rows") int rows, @Query("start") int start);
}
