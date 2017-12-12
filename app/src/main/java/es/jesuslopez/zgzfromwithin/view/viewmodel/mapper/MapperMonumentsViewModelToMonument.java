package es.jesuslopez.zgzfromwithin.view.viewmodel.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Mapper;
import es.jesuslopez.zgzfromwithin.domain.model.Monument;
import es.jesuslopez.zgzfromwithin.view.viewmodel.MonumentViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class MapperMonumentsViewModelToMonument extends Mapper<Monument, MonumentViewModel> {

    @Inject
    public MapperMonumentsViewModelToMonument() {
    }

    @Override
    public MonumentViewModel map(Monument monument) {
        MonumentViewModel monumentViewModel = new MonumentViewModel();
        monumentViewModel.setAddress(monument.getAddress());
        monumentViewModel.setDescription(monument.getDescription());
        monumentViewModel.setImage(monument.getImage());
        monumentViewModel.setName(monument.getName());
        monumentViewModel.setPhone(monument.getPhone());
        monumentViewModel.setPublicAccess(monument.getPublicAccess());
        monumentViewModel.setVideo(monument.getVideo());

        return monumentViewModel;
    }
}
