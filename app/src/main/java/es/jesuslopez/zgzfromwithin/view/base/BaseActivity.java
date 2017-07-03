package es.jesuslopez.zgzfromwithin.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;

/**
 * Created by JesusLopez on 3/7/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutActivity());
        setToolbar(getToolbar());
        bindViews();
    }

    protected abstract int getLayoutActivity();

    private void bindViews() {
        ButterKnife.bind(this);
    }

    protected abstract Toolbar getToolbar();

    protected void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

}
