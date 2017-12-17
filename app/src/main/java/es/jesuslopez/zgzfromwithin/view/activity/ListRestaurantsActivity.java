package es.jesuslopez.zgzfromwithin.view.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.ZfwApplication;
import es.jesuslopez.zgzfromwithin.view.adapter.ListRestaurantsAdapter;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;
import es.jesuslopez.zgzfromwithin.view.listener.EndlessRecyclerOnScrollListener;
import es.jesuslopez.zgzfromwithin.view.presenter.ListRestaurantsPresenter;
import es.jesuslopez.zgzfromwithin.view.viewmodel.mapper.RestaurantViewModel;

public class ListRestaurantsActivity extends BaseActivity implements ListRestaurantsPresenter.View {

    @Inject
    ListRestaurantsPresenter listRestaurantsPresenter;
    @BindView(R.id.recyclerViewRestaurants)
    RecyclerView recyclerViewRestaurants;
    @BindView(R.id.progressBarListRestaurants)
    ProgressBar progressBar;
    @BindView(R.id.progressBarLoading)
    ProgressBar progressBarLoading;

    private ListRestaurantsAdapter listRestaurantsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDagger();
        setPresenter();
        configToolbar();
        setAdapter();
        setView();
        initializePresenter();
    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_list_restaurants;
    }

    private void setDagger() {
        ZfwApplication zfwApplication = (ZfwApplication) getApplication();
        zfwApplication.getSystemComponent().inject(this);
    }

    private void setPresenter() {
        listRestaurantsPresenter.setView(this);
    }

    private void initializePresenter() {
        showProgressBar();
        listRestaurantsPresenter.init();
    }

    private void setAdapter() {
        listRestaurantsAdapter = new ListRestaurantsAdapter(ListRestaurantsActivity.this);
    }

    private void setView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListRestaurantsActivity.this);
        recyclerViewRestaurants.setLayoutManager(linearLayoutManager);
        recyclerViewRestaurants.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        if (listRestaurantsAdapter != null) {
            recyclerViewRestaurants.setAdapter(listRestaurantsAdapter);
        }

        recyclerViewRestaurants.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                addDataToList();
            }
        });
    }

    private void addDataToList() {
        progressBar.setVisibility(View.VISIBLE);
        listRestaurantsPresenter.init();
    }

    @Override
    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void showListRestaurants(List<RestaurantViewModel> listRestaurants) {
        progressBarLoading.setVisibility(View.GONE);
        listRestaurantsAdapter.addAllItems(listRestaurants);
        listRestaurantsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBarLoading.setVisibility(View.VISIBLE);
        recyclerViewRestaurants.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLoading.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerViewRestaurants.setVisibility(View.VISIBLE);
    }

    private void configToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
