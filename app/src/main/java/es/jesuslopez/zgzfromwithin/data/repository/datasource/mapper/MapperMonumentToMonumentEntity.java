package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import javax.inject.Inject;

import es.jesuslopez.zgzfromwithin.data.entity.MonumentEntity;
import es.jesuslopez.zgzfromwithin.domain.model.Monument;

/**
 * Created by JesusLopez on 15/7/17.
 */

public class MapperMonumentToMonumentEntity extends Mapper<MonumentEntity, Monument> {

    @Inject
    public MapperMonumentToMonumentEntity() {
    }

    @Override
    public Monument map(MonumentEntity monumentEntity) {
        Monument monument = new Monument();
        monument.setAddress(monumentEntity.getMonumentAddress());
        monument.setDescription(monumentEntity.getMonumentDescription());
        monument.setImage(monumentEntity.getMonumentHeaderImage());
        monument.setName(monumentEntity.getMonumentName());
        monument.setPhone(monumentEntity.getMonumentPhone());
        monument.setPublicAccess(monumentEntity.getMonumentHorary());
        monument.setVideo(monumentEntity.getMonumentVideo());
        return monument;
    }
}
