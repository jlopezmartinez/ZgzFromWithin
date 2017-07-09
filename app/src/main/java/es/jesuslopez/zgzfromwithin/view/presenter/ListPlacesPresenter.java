package es.jesuslopez.zgzfromwithin.view.presenter;


import java.util.List;

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

    public ListPlacesPresenter(GetPlaces getPlaces, MapperPlacesViewModelToPlace mapperPlacesViewModelToPlace) {
        this.getPlaces = getPlaces;
        this.mapper = mapperPlacesViewModelToPlace;
    }

    public interface View {
        void showListPlaces(List<PlaceViewModel> placesList);
    }

    public void init() {
        super.init();
        getPlaces.executeObserver(new LisPlacesObserver());
    }

    private final class LisPlacesObserver extends UseCaseObserver<List<Place>> {
        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override
        public void onNext(List<Place> listPlaces) {
            super.onNext(listPlaces);
            List<PlaceViewModel> listPlaceViewModel = mapper.map(listPlaces);
            getView().showListPlaces(listPlaceViewModel);
        }
    }
}