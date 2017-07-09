package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

/**
 * Created by JesusLopez on 7/7/17.
 */

public class ListPlacesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PlaceViewModel> listPlaces;

    public ListPlacesAdapter() {
        listPlaces = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PlaceViewHolder placeViewHolder = (PlaceViewHolder) holder;
        placeViewHolder.setView(listPlaces.get(position));
    }

    @Override
    public int getItemCount() {
        return listPlaces.size();
    }

    public void addAllItems(Collection<PlaceViewModel> placesCollection) {
        listPlaces.addAll(placesCollection);
    }
}
