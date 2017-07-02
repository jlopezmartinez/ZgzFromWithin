package es.jesuslopez.zgzfromwithin.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by JesusLopez on 2/7/17.
 */

abstract class UseCase<T> {
    private final CompositeDisposable compositeDisposable;
    private final Scheduler executorSchedule;
    private final Scheduler uiSchedule;

    UseCase(Scheduler executorSchedule, Scheduler uiSchedule) {
        compositeDisposable = new CompositeDisposable();
        this.executorSchedule = executorSchedule;
        this.uiSchedule = uiSchedule;
    }

    protected abstract Observable<T> getObservableUseCase();
}
