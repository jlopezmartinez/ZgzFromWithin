package es.jesuslopez.zgzfromwithin.view.presenter;


import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.domain.model.Monument;
import es.jesuslopez.zgzfromwithin.domain.usecase.GetMonuments;
import es.jesuslopez.zgzfromwithin.domain.usecase.UseCaseObserver;
import es.jesuslopez.zgzfromwithin.view.viewmodel.MonumentViewModel;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.MapperMonumentsViewModelToMonument;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class ListMonumentsPresenter extends Presenter<ListMonumentsPresenter.View> {

    private MapperMonumentsViewModelToMonument mapper;
    private GetMonuments getMonuments;
    private int currentListPosition = 0;

    @Inject
    public ListMonumentsPresenter(GetMonuments getMonuments, MapperMonumentsViewModelToMonument mapperMonumentsViewModelToMonument) {
        this.getMonuments = getMonuments;
        this.mapper = mapperMonumentsViewModelToMonument;
    }

    public interface View extends Presenter.View {
        void showListMonuments(List<MonumentViewModel> monumentList);
    }

    @Override
    public void init() {
        super.init();
        getMonuments.executeObserver(new LisMonumentsObserver(), currentListPosition, 10);
    }

    private final class LisMonumentsObserver extends UseCaseObserver<List<Monument>> {
        @Override
        public void onComplete() {
            getView().hideProgressBar();
        }

        @Override
        public void onError(Throwable e) {
            getView().hideProgressBar();
        }

        @Override
        public void onNext(List<Monument> listMonuments) {
            super.onNext(listMonuments);
            currentListPosition += 10;
            List<MonumentViewModel> listMonumentViewModel = mapper.map(listMonuments);
            getView().showListMonuments(listMonumentViewModel);
        }
    }
}