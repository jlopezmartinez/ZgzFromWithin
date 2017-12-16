package es.jesuslopez.zgzfromwithin.view.presenter;


import java.util.List;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.domain.model.Restaurant;
import es.jesuslopez.zgzfromwithin.domain.usecase.GetRestaurants;
import es.jesuslopez.zgzfromwithin.domain.usecase.UseCaseObserver;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.MapperRestaurantsViewModelToRestaurant;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.RestaurantViewModel;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class ListRestaurantsPresenter extends Presenter<ListRestaurantsPresenter.View> {

    private MapperRestaurantsViewModelToRestaurant mapper;
    private GetRestaurants getRestaurants;
    private int currentListPosition = 0;

    @Inject
    public ListRestaurantsPresenter(GetRestaurants getRestaurants, MapperRestaurantsViewModelToRestaurant mapperRestaurantsViewModelToRestaurant) {
        this.getRestaurants = getRestaurants;
        this.mapper = mapperRestaurantsViewModelToRestaurant;
    }

    public interface View extends Presenter.View {
        void showListRestaurants(List<RestaurantViewModel> restaurantList);
    }

    @Override
    public void init() {
        super.init();
        getRestaurants.executeObserver(new ListRestaurantsObserver(), currentListPosition, 10);
    }

    private final class ListRestaurantsObserver extends UseCaseObserver<List<Restaurant>> {
        @Override
        public void onComplete() {
            getView().hideProgressBar();
        }

        @Override
        public void onError(Throwable e) {
            getView().hideProgressBar();
        }

        @Override
        public void onNext(List<Restaurant> listRestaurants) {
            super.onNext(listRestaurants);
            currentListPosition += 10;
            List<RestaurantViewModel> listRestaurantViewModel = mapper.map(listRestaurants);
            getView().showListRestaurants(listRestaurantViewModel);
        }
    }
}