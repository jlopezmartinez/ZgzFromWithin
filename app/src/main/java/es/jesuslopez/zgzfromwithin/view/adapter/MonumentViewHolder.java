package es.jesuslopez.zgzfromwithin.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.viewmodel.MonumentViewModel;

/**
 * Created by JesusLopez on 9/7/17.
 */

public class MonumentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.monumentNameView)
    TextView monumentNameView;

    @BindView(R.id.monumentImageView)
    ImageView monumentImageView;

    public MonumentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setView(MonumentViewModel monumentViewModel) {
        setmonumentName(monumentViewModel.getName());
        setmonumentImage(monumentViewModel.getImage());
    }

    private void setmonumentName(String monumentTitle) {
        monumentNameView.setText(monumentTitle);
    }

    private void setmonumentImage(String monumentImage) {
        Picasso.with(itemView.getContext()).load(monumentImage).fit().centerCrop().into(monumentImageView);
    }
}