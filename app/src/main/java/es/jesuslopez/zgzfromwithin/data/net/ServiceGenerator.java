package es.jesuslopez.zgzfromwithin.data.net;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class ServiceGenerator {
    private static PlacesService placesService;

    public static PlacesService getPlacesService() {
        if (placesService == null) {
            placesService = RetrofitHelper.getRetrofit().create(PlacesService.class);
        }
        return placesService;
    }
}
