package es.jesuslopez.zgzfromwithin.data.local;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import es.jesuslopez.zgzfromwithin.data.entity.MonumentEntity;
import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.JSONMapperMonumentEntity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by JesusLopez on 18/7/17.
 */

public class LocalImpl implements LocalApi {

    private Context context;
    private JSONMapperMonumentEntity jsonMapperMonumentEntity;

    public LocalImpl(Context context, JSONMapperMonumentEntity jsonMapperMonumentEntity) {
        this.context = context;
        this.jsonMapperMonumentEntity = jsonMapperMonumentEntity;
    }

    @Override
    public Observable<List<MonumentEntity>> monumentListEntity() {
        return Observable.create(new ObservableOnSubscribe<List<MonumentEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<MonumentEntity>> e) throws Exception {
                List<MonumentEntity> listPlaces = getAllPlaces();
                if (listPlaces != null) {
                    e.onNext(listPlaces);
                    e.onComplete();
                } else {
                    e.onError(new Throwable("Error getting data"));
                }
            }
        });
    }

    private List<MonumentEntity> getAllPlaces() {
        return jsonMapperMonumentEntity.getListMonumentsEntityFromJSON(getDataFromLocal());
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
