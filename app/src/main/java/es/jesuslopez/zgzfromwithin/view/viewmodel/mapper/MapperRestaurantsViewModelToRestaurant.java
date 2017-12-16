package es.jesuslopez.zgzfromwithin.view.viewmodel.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Mapper;
import es.jesuslopez.zgzfromwithin.domain.model.Restaurant;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class MapperRestaurantsViewModelToRestaurant extends Mapper<Restaurant, RestaurantViewModel> {

    @Inject
    public MapperRestaurantsViewModelToRestaurant() {
    }

    @Override
    public RestaurantViewModel map(Restaurant restaurant) {
        RestaurantViewModel restaurantViewModel = new RestaurantViewModel();
        restaurantViewModel.setName(restaurant.getName());
        restaurantViewModel.setAccesibility(restaurant.getAccesibility());
        restaurantViewModel.setAddress(restaurant.getAddress());
        restaurantViewModel.setCapacity(restaurant.getCapacity());
        restaurantViewModel.setEmail(restaurant.getEmail());
        restaurantViewModel.setForks(restaurant.getForks());
        restaurantViewModel.setGeometry(restaurant.getGeometry());
        restaurantViewModel.setImage(restaurant.getImage());
        restaurantViewModel.setLocality(restaurant.getLocality());
        restaurantViewModel.setLogo(restaurant.getLogo());
        restaurantViewModel.setPhone(restaurant.getPhone());
        restaurantViewModel.setPostalCode(restaurant.getPostalCode());
        restaurantViewModel.setWebPage(restaurant.getWebPage());

        return restaurantViewModel;
    }
}
