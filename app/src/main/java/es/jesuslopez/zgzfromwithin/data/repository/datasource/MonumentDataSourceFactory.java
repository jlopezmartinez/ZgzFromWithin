package es.jesuslopez.zgzfromwithin.data.repository.datasource;

import android.content.Context;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.net.NetImpl;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MonumentDataSourceFactory {

    private final Context context;

    @Inject
    public MonumentDataSourceFactory(Context ctx) {
        this.context = ctx;
    }

    public MonumentNetApiDataSource getDataSource() {
        NetImpl netImpl = new NetImpl();
        return new MonumentNetApiDataSource(netImpl);
    }
}
