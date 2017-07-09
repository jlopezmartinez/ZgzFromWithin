package es.jesuslopez.zgzfromwithin.domain.usecase;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by JesusLopez on 7/7/17.
 */

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
