package es.jesuslopez.zgzfromwithin.view.presenter;


import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.domain.model.Place;
import es.jesuslopez.zgzfromwithin.domain.usecase.GetPlaces;
import es.jesuslopez.zgzfromwithin.domain.usecase.UseCaseObserver;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.MapperPlacesViewModelToPlace;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class ListPlacesPresenter extends Presenter<ListPlacesPresenter.View> {

    private MapperPlacesViewModelToPlace mapper;
    private GetPlaces getPlaces;

    @Inject
    public ListPlacesPresenter(GetPlaces getPlaces, MapperPlacesViewModelToPlace mapperPlacesViewModelToPlace) {
        this.getPlaces = getPlaces;
        this.mapper = mapperPlacesViewModelToPlace;
    }

    public interface View extends Presenter.View {
        void showListPlaces(List<PlaceViewModel> placesList);
    }

    @Override
    public void init() {
        super.init();
        getView().showProgressBar();
        getPlaces.executeObserver(new LisPlacesObserver());
    }

    private final class LisPlacesObserver extends UseCaseObserver<List<Place>> {
        @Override
        public void onComplete() {
            getView().hideProgressBar();
        }

        @Override
        public void onError(Throwable e) {
            getView().hideProgressBar();
        }

        @Override
        public void onNext(List<Place> listPlaces) {
            super.onNext(listPlaces);
            List<PlaceViewModel> listPlaceViewModel = mapper.map(listPlaces);
            getView().showListPlaces(listPlaceViewModel);
        }
    }
}