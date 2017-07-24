package es.jesuslopez.zgzfromwithin.data.local;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        StringBuilder buf = new StringBuilder();
        InputStream json;
        try {
            json = context.getAssets().open("LIST_PLACES.json");
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return buf.toString();
    }
}
