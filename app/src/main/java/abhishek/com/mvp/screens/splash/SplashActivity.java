package abhishek.com.mvp.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import abhishek.com.mvp.base.BaseActivity;
import abhishek.com.mvp.screens.login.LoginActivity;

/**
 * Created by abhishek on 9/11/16.
 */

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 1800);
    }
}
