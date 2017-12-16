package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.RestaurantViewModel;

/**
 * Created by JesusLopez on 7/7/17.
 */

public class ListRestaurantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<RestaurantViewModel> listRestaurants;

    public ListRestaurantsAdapter() {
        listRestaurants = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RestaurantViewHolder restaurantViewHolder = (RestaurantViewHolder) holder;
        restaurantViewHolder.setView(listRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return listRestaurants.size();
    }

    public void addAllItems(Collection<RestaurantViewModel> restaurantCollection) {
        listRestaurants.addAll(restaurantCollection);
    }
}
