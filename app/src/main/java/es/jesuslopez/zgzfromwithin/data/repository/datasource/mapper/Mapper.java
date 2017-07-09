package es.jesuslopez.zgzfromwithin.data.repository.datasource.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JesusLopez on 9/7/17.
 */

public abstract class Mapper<T1, T2> {

    public abstract T2 map(T1 value);

    public List<T2> map(List<T1> list) {
        List<T2> returnedList = new ArrayList<>(list.size());
        for (T1 itemList : list) {
            returnedList.add(map(itemList));
        }
        return returnedList;
    }
}
