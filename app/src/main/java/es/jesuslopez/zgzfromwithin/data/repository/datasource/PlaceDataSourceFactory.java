package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.net.NetImpl;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class PlaceDataSourceFactory {

    private final Context context;

    @Inject
    public PlaceDataSourceFactory(Context ctx) {
        this.context = ctx;
    }

    public PlaceNetApiDataSource getDataSource() {
        NetImpl netImpl = new NetImpl();
        return new PlaceNetApiDataSource(netImpl);
    }
}
