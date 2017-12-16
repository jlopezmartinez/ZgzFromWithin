package es.jesuslopez.zgzfromwithin.domain.usecase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import es.jesuslopez.zgzfromwithin.data.repository.RestaurantRepository;
import es.jesuslopez.zgzfromwithin.domain.model.Restaurant;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class GetRestaurants extends UseCase<List<Restaurant>> {

    private final RestaurantRepository restaurantRepository;

    @Inject
    public GetRestaurants(@Named("executor_schedule") Scheduler executorSchedule, @Named("ui_schedule") Scheduler uiSchedule,
                          RestaurantRepository restaurantRepository) {
        super(executorSchedule, uiSchedule);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    protected Observable<List<Restaurant>> createObservableUseCase(int from, int limit) {
        return restaurantRepository.restaurantList(from, limit);
    }
}
