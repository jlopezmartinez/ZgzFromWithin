package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.placeNameView)
    TextView placeNameView;

    @BindView(R.id.placeImageView)
    ImageView placeImageView;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setView(PlaceViewModel placeViewModel) {
        setPlaceName(placeViewModel.getName());
        setPlaceImage(placeViewModel.getImage());
    }

    private void setPlaceName(String placeTitle) {
        placeNameView.setText(placeTitle);
    }

    private void setPlaceImage(String placeImage) {
        Picasso.with(itemView.getContext()).load(placeImage).fit().centerCrop().into(placeImageView);
    }
}