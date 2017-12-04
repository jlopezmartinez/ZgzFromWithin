package es.jesuslopez.zgzfromwithin.di.components;

import javax.inject.Singleton;

import dagger.Component;
import es.jesuslopez.zgzfromwithin.di.modules.MainModule;
import es.jesuslopez.zgzfromwithin.view.activity.ListPlacesActivity;
import es.jesuslopez.zgzfromwithin.view.activity.MenuActivity;

/**
 * Created by JesusLopez on 4/7/17.
 */

@Singleton
@Component(modules = MainModule.class)
public interface SystemComponent {
    void inject(MenuActivity menuActivity);

    void inject(ListPlacesActivity listPlacesActivity);
}