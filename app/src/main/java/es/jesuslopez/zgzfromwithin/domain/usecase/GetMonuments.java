package es.jesuslopez.zgzfromwithin.domain.usecase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import es.jesuslopez.zgzfromwithin.data.repository.MonumentRepository;
import es.jesuslopez.zgzfromwithin.domain.model.Monument;
import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by JesusLopez on 2/7/17.
 */

public class GetMonuments extends UseCase<List<Monument>> {

    private final MonumentRepository monumentRepository;

    @Inject
    public GetMonuments(@Named("executor_schedule") Scheduler executorSchedule, @Named("ui_schedule") Scheduler uiSchedule,
                        MonumentRepository MonumentRepository) {
        super(executorSchedule, uiSchedule);
        this.monumentRepository = MonumentRepository;
    }

    @Override
    protected Observable<List<Monument>> createObservableUseCase(int from, int limit) {
        return monumentRepository.monumentList(from, limit);
    }
}
