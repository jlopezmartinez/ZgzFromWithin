package es.jesuslopez.zgzfromwithin.domain.model;

import java.util.List;

/**
 * Created by JesusLopez on 16/12/17.
 */

public class Geometry {
    private String type;
    private List<Double> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
