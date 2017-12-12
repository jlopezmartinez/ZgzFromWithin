package es.jesuslopez.zgzfromwithin.data.net;

import es.jesuslopez.zgzfromwithin.data.entity.ResponseEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public interface PlacesService {
    @GET("monumento.json?")
    Observable<ResponseEntity> getListMonuments(@Query("rows") int rows, @Query("start") int start);

    @GET("restaurante.json?")
    Observable<ResponseEntity> getListRestaurants(@Query("rows") int rows, @Query("start") int start);

    @GET("alojamiento.json?")
    Observable<ResponseEntity> getListAccomodations(@Query("rows") int rows, @Query("start") int start);
}
