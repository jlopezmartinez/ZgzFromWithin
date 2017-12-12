package es.jesuslopez.zgzfromwithin.data.local;

import java.util.List;

import es.jesuslopez.zgzfromwithin.data.entity.MonumentEntity;
import io.reactivex.Observable;

/**
 * Created by JesusLopez on 15/7/17.
 */

public interface LocalApi {
    Observable<List<MonumentEntity>> monumentListEntity();
}
