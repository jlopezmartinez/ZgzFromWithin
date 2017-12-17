package es.jesuslopez.zgzfromwithin.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.MonumentViewModel;

/**
 * Created by JesusLopez on 7/7/17.
 */

public class ListMonumentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MonumentViewModel> listMonuments;
    private Context context;

    public ListMonumentsAdapter(Context context) {
        listMonuments = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monument, parent, false);
        return new MonumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MonumentViewHolder monumentViewHolder = (MonumentViewHolder) holder;
        monumentViewHolder.setView(listMonuments.get(position), context);
    }

    @Override
    public int getItemCount() {
        return listMonuments.size();
    }

    public void addAllItems(Collection<MonumentViewModel> monumentsCollection) {
        listMonuments.addAll(monumentsCollection);
    }
}
