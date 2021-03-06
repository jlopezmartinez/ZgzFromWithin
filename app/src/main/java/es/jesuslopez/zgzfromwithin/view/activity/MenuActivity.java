package es.jesuslopez.zgzfromwithin.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;

public class MenuActivity extends BaseActivity {

    @BindView(R.id.buttonMomunments)
    RelativeLayout buttonMomunments;

    @BindView(R.id.buttonRestaurants)
    RelativeLayout buttonRestaurants;

    @BindView(R.id.buttonAccomodations)
    RelativeLayout buttonAccomodations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        disableToolbarTitle();

        setListeners();
    }

    private void setListeners() {
        buttonMomunments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListDetails(new Intent(MenuActivity.this, ListMonumentsActivity.class));
            }
        });

        buttonAccomodations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListDetails(new Intent(MenuActivity.this, ListRestaurantsActivity.class));
            }
        });

        buttonRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListDetails(new Intent(MenuActivity.this, ListRestaurantsActivity.class));
            }
        });
    }

    private void openListDetails(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_menu;
    }

    @Override
    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    private void disableToolbarTitle() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
