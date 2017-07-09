package es.jesuslopez.zgzfromwithin.view.presenter;

/**
 * Created by JesusLopez on 6/7/17.
 */

public class Presenter<T> {

    private T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }


    public void init() {
    }
}
