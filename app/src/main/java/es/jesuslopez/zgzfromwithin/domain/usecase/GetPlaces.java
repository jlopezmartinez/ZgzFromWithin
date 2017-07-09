package es.jesuslopez.zgzfromwithin.domain.usecase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import es.jesuslopez.zgzfromwithin.data.repository.PlaceRepository;
import es.jesuslopez.zgzfromwithin.domain.model.Place;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class GetPlaces extends UseCase<List<Place>> {

    private final PlaceRepository placeRepository;

    @Inject
    public GetPlaces(@Named("executor_schedule") Scheduler executorSchedule, @Named("ui_schedule") Scheduler uiSchedule,
                     PlaceRepository placeRepository) {
        super(executorSchedule, uiSchedule);
        this.placeRepository = placeRepository;
    }

    @Override
    protected Observable<List<Place>> createObservableUseCase() {
        return placeRepository.placeList();
    }
}
