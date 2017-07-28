package es.jesuslopez.zgzfromwithin.view.viewmodel.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper.Mapper;
import es.jesuslopez.zgzfromwithin.domain.model.Place;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class MapperPlacesViewModelToPlace extends Mapper<Place, PlaceViewModel> {

    @Inject
    public MapperPlacesViewModelToPlace() {
    }

    @Override
    public PlaceViewModel map(Place place) {
        PlaceViewModel placeViewModel = new PlaceViewModel();
        placeViewModel.setAddress(place.getAddress());
        placeViewModel.setDescription(place.getDescription());
        placeViewModel.setImage(place.getImage());
        placeViewModel.setName(place.getName());
        placeViewModel.setPhone(place.getPhone());
        placeViewModel.setPublicAccess(place.getPublicAccess());
        placeViewModel.setVideo(place.getVideo());

        return placeViewModel;
    }
}
