package es.jesuslopez.zgzfromwithin.view.activity;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import es.jesuslopez.zgzfromwithin.R;
import es.jesuslopez.zgzfromwithin.view.base.BaseActivity;

/**
 * Created by JesusLopez on 3/8/17.
 */

public class SplashScreenActivity extends BaseActivity {

    @BindView(R.id.layout)
    LinearLayout layout;

    @BindView(R.id.splash)
    ImageView imageViewSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startAnimation();
        initHandler();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    protected int getLayoutActivity() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected Toolbar getToolbar() {
        return null;
    }

    private void startAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();

        layout.clearAnimation();
        layout.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        imageViewSplash.clearAnimation();
        imageViewSplash.startAnimation(anim);
    }

    private void initHandler() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initMainActivity();
            }
        }, 3500);
    }

    private void initMainActivity() {
        Intent intent = new Intent(SplashScreenActivity.this,
                MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
