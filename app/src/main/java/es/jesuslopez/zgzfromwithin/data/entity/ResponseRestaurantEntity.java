package es.jesuslopez.zgzfromwithin.data.entity;

import java.util.ArrayList;

/**
 * Created by JesusLopez on 4/12/17.
 */

public class ResponseRestaurantEntity {

    private int totalCount;
    private int start;
    private int rows;
    private ArrayList<RestaurantEntity> result;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public ArrayList<RestaurantEntity> getResult() {
        return result;
    }

    public void setResult(ArrayList<RestaurantEntity> result) {
        this.result = result;
    }
}
