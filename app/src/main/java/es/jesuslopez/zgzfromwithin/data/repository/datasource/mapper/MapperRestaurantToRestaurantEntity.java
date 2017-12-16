package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.RestaurantEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Restaurant;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MapperRestaurantToRestaurantEntity extends Mapper<RestaurantEntity, Restaurant> {

    @Inject
    public MapperRestaurantToRestaurantEntity() {
    }

    @Override
    public Restaurant map(RestaurantEntity restaurantEntity) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantEntity.getName());
        restaurant.setAccesibility(restaurantEntity.getAccesibility());
        restaurant.setAddress(restaurantEntity.getAddress());
        restaurant.setCapacity(restaurantEntity.getCapacity());
        restaurant.setEmail(restaurantEntity.getEmail());
        restaurant.setForks(restaurantEntity.getForks());
        restaurant.setGeometry(restaurantEntity.getGeometry());
        restaurant.setImage(restaurantEntity.getImage());
        restaurant.setLocality(restaurantEntity.getLocality());
        restaurant.setLogo(restaurantEntity.getLogo());
        restaurant.setPhone(restaurantEntity.getPhone());
        restaurant.setPostalCode(restaurantEntity.getPostalCode());
        restaurant.setWebPage(restaurantEntity.getWebPage());
        return restaurant;
    }
}
