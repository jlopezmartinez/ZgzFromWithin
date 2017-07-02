package es.jesuslopez.zgzfromwithin.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.jesuslopez.zgzfromwithin.ZfwApplication;

@Module
public class MainModule {

    private final ZfwApplication zfwApplication;

    public MainModule(ZfwApplication zfwApplication) {
        this.zfwApplication = zfwApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return zfwApplication;
    }

}
