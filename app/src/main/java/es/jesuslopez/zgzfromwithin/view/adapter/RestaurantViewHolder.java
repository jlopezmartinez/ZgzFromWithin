package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.RestaurantViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class RestaurantViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.restaurantNameView)
    TextView restaurantNameView;

    @BindView(R.id.restaurantImageView)
    ImageView restaurantImageView;

    private final String BASE_IMAGE_URL = "https://www.zaragoza.es";

    public RestaurantViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setView(RestaurantViewModel restaurantViewModel) {
        setRestaurantName(restaurantViewModel.getName());
        setRestaurantImage(BASE_IMAGE_URL + restaurantViewModel.getImage());
    }

    private void setRestaurantName(String monumentTitle) {
        restaurantNameView.setText(monumentTitle);
    }

    private void setRestaurantImage(String monumentImage) {
        Picasso.with(itemView.getContext()).load(monumentImage).fit().centerCrop().into(restaurantImageView);
    }
}