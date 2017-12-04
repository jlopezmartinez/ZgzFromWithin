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
import es.jesuslopez.zgzfromwithin.view.adapter.ListPlacesAdapter;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;
import es.jesuslopez.zgzfromwithin.view.listener.EndlessRecyclerOnScrollListener;
import es.jesuslopez.zgzfromwithin.view.presenter.ListPlacesPresenter;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

public class ListPlacesActivity extends BaseActivity implements ListPlacesPresenter.View {

    @Inject
    ListPlacesPresenter listPlacesPresenter;
    @BindView(R.id.recyclerViewPlaces)
    RecyclerView recyclerViewPlaces;
    @BindView(R.id.progressBarListPlaces)
    ProgressBar progressBar;

    private ListPlacesAdapter listPlacesAdapter;

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
        return R.layout.activity_list_places;
    }

    private void setDagger() {
        ZfwApplication zfwApplication = (ZfwApplication) getApplication();
        zfwApplication.getSystemComponent().inject(this);
    }

    private void setPresenter() {
        listPlacesPresenter.setView(this);
    }

    private void initializePresenter() {
        listPlacesPresenter.init();
    }

    private void setAdapter() {
        listPlacesAdapter = new ListPlacesAdapter();
    }

    private void setView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListPlacesActivity.this);
        recyclerViewPlaces.setLayoutManager(linearLayoutManager);
        recyclerViewPlaces.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        if (listPlacesAdapter != null) {
            recyclerViewPlaces.setAdapter(listPlacesAdapter);
        }

        recyclerViewPlaces.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                addDataToList();
            }
        });
    }

    private void addDataToList() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Toolbar getToolbar() {
        return (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void showListPlaces(List<PlaceViewModel> listPlaces) {
        listPlacesAdapter.addAllItems(listPlaces);
        listPlacesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewPlaces.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerViewPlaces.setVisibility(View.VISIBLE);
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
