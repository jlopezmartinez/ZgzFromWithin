package es.jesuslopez.zgzfromwithin.di.modules;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.jesuslopez.zgzfromwithin.ZfwApplication;
import es.jesuslopez.zgzfromwithin.data.repository.MonumentRepository;
import es.jesuslopez.zgzfromwithin.data.repository.Repository;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    @Provides
    @Singleton
    Repository provideRepository(MonumentRepository MonumentRepository) {
        return MonumentRepository;
    }

    @Provides
    @Named("executor_schedule")
    Scheduler provideExecutorThread() {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_schedule")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}