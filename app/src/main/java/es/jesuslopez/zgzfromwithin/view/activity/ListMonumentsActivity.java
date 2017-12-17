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
import es.jesuslopez.zgzfromwithin.view.adapter.ListMonumentsAdapter;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;
import es.jesuslopez.zgzfromwithin.view.listener.EndlessRecyclerOnScrollListener;
import es.jesuslopez.zgzfromwithin.view.presenter.ListMonumentsPresenter;
import es.jesuslopez.zgzfromwithin.view.viewmodel.MonumentViewModel;

public class ListMonumentsActivity extends BaseActivity implements ListMonumentsPresenter.View {

    @Inject
    ListMonumentsPresenter listMonumentsPresenter;
    @BindView(R.id.recyclerViewMonuments)
    RecyclerView recyclerViewMonuments;
    @BindView(R.id.progressBarListMonuments)
    ProgressBar progressBar;
    @BindView(R.id.progressBarLoading)
    ProgressBar progressBarLoading;

    private ListMonumentsAdapter listMonumentsAdapter;

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
        return R.layout.activity_list_monuments;
    }

    private void setDagger() {
        ZfwApplication zfwApplication = (ZfwApplication) getApplication();
        zfwApplication.getSystemComponent().inject(this);
    }

    private void setPresenter() {
        listMonumentsPresenter.setView(this);
    }

    private void initializePresenter() {
        showProgressBar();
        listMonumentsPresenter.init();
    }

    private void setAdapter() {
        listMonumentsAdapter = new ListMonumentsAdapter(ListMonumentsActivity.this);
    }

    private void setView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListMonumentsActivity.this);
        recyclerViewMonuments.setLayoutManager(linearLayoutManager);
        recyclerViewMonuments.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        if (listMonumentsAdapter != null) {
            recyclerViewMonuments.setAdapter(listMonumentsAdapter);
        }

        recyclerViewMonuments.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                addDataToList();
            }
        });
    }

    private void addDataToList() {
        progressBar.setVisibility(View.VISIBLE);
        listMonumentsPresenter.init();
    }

    @Override
    protected Toolbar getToolbar() {
        return (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void showListMonuments(List<MonumentViewModel> listMonuments) {
        progressBarLoading.setVisibility(View.GONE);
        listMonumentsAdapter.addAllItems(listMonuments);
        listMonumentsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBarLoading.setVisibility(View.VISIBLE);
        recyclerViewMonuments.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBarLoading.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerViewMonuments.setVisibility(View.VISIBLE);
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
