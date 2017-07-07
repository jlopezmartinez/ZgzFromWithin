package es.jesuslopez.zgzfromwithin.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.ZfwApplication;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;

public class ListPlacesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDagger();
        initPresenter();
    }

    private void initDagger() {
        ZfwApplication zfwApplication = (ZfwApplication) getApplication();
        zfwApplication.getSystemComponent().inject(this);
    }

    private void initPresenter() {

    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_list_places;
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }
}
