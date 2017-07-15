package es.jesuslopez.zgzfromwithin.view.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.ZfwApplication;
import es.jesuslopez.zgzfromwithin.view.adapter.ListPlacesAdapter;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;
import es.jesuslopez.zgzfromwithin.view.presenter.ListPlacesPresenter;
import es.jesuslopez.zgzfromwithin.view.viewmodel.PlaceViewModel;

public class ListPlacesActivity extends BaseActivity implements ListPlacesPresenter.View {

    @Inject
    ListPlacesPresenter listPlacesPresenter;
    @BindView(R.id.recyclerViewPlaces)
    RecyclerView recyclerViewPlaces;

    private ListPlacesAdapter listPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDagger();
        setPresenter();
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
        recyclerViewPlaces.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlaces.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        if (listPlacesAdapter != null) {
            recyclerViewPlaces.setAdapter(listPlacesAdapter);
        }
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    @Override
    public void showListPlaces(List<PlaceViewModel> listPlaces) {
        listPlacesAdapter.addAllItems(listPlaces);
        listPlacesAdapter.notifyDataSetChanged();
    }
}
