package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.PlaceEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Place;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MapperPlaceToPlaceEntity extends Mapper<PlaceEntity, Place> {

    @Inject
    public MapperPlaceToPlaceEntity() {
    }

    @Override
    public Place map(PlaceEntity placeEntity) {
        Place place = new Place();
        place.setAddress(placeEntity.getPlaceAddress());
        place.setDescription(placeEntity.getPlaceDescription());
        place.setImage(placeEntity.getPlaceHeaderImage());
        place.setName(placeEntity.getPlaceName());
        place.setPhone(placeEntity.getPlacePhone());
        place.setPublicAccess(placeEntity.getPlaceHorary());
        place.setVideo(placeEntity.getPlaceVideo());
        return place;
    }
}
