package es.jesuslopez.zgzfromwithin.data.local;

import android.content.Context;

import java.util.List;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.JSONMapperPlaceEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by JesusLopez on 18/7/17.
 */

public class LocalImpl implements LocalApi {

    private Context context;
    private JSONMapperPlaceEntity jsonMapperPlaceEntity;

    public LocalImpl(Context context, JSONMapperPlaceEntity jsonMapperPlaceEntity) {
        this.context = context;
        this.jsonMapperPlaceEntity = jsonMapperPlaceEntity;
    }

    @Override
    public Observable<List<PlaceEntity>> placeListEntity() {
        return Observable.create(new ObservableOnSubscribe<List<PlaceEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<PlaceEntity>> e) throws Exception {
                List<PlaceEntity> listPlaces = getAllPlaces();
            }
        });
    }

    private List<PlaceEntity> getAllPlaces() {
        return jsonMapperPlaceEntity.getListPlacesEntityFromJSON(getDataFromLocal());
    }

    private String getDataFromLocal() {
        //TODO//JLOPEZ//
        //CREATE HERE JSON AND ADD TO ASSESTS FOLDER//
        return "";
    }
}
