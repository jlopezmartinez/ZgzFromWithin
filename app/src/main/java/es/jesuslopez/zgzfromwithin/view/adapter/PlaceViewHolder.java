package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textViewPlaceName)
    TextView textViewPlaceName;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void setView(PlaceViewModel placeViewModel) {
        setPlaceName(placeViewModel);
    }

    private void setPlaceName(PlaceViewModel placeViewModel) {
        textViewPlaceName.setText(placeViewModel.getName());
    }
}
