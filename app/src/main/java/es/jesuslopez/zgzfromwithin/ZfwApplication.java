package es.jesuslopez.zgzfromwithin;

import android.app.Application;

import es.jesuslopez.zgzfromwithin.di.components.DaggerSystemComponent;
import es.jesuslopez.zgzfromwithin.di.components.SystemComponent;
import es.jesuslopez.zgzfromwithin.di.modules.MainModule;

/**
 * Created by JesusLopez on 1/7/17.
 */

public class ZfwApplication extends Application {

    private SystemComponent systemComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
    }

    private void initDagger() {
        systemComponent = DaggerSystemComponent.builder().mainModule(new MainModule(this)).build();
    }

    public SystemComponent getSystemComponent() {
        return systemComponent;
    }
}
