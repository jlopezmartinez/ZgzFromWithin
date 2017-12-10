package es.jesuslopez.zgzfromwithin.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

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

    public void executeObserver(DisposableObserver<T> observer, int from, int limit) {
        if (observer != null) {
            final Observable<T> observable = createObservableUseCase(from, limit).subscribeOn(executorSchedule).observeOn(uiSchedule);

            DisposableObserver disposableObserver = observable.subscribeWith(observer);
            compositeDisposable.add(disposableObserver);
        }
    }

    protected abstract Observable<T> createObservableUseCase(int from, int limit);
}
