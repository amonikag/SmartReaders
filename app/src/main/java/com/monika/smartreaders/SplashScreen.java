package com.monika.smartreaders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class SplashScreen extends AppCompatActivity {
    Animation  bottomAnim;
    LottieAnimationView
            book, batch;
    TextView appname, slogan;
    private static final String TAG = "SplashScreen";
    private static int SPLASH_TIMER = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        //hooks
        appname = findViewById(R.id.appName);
        slogan = findViewById(R.id.slogan);
        book = findViewById(R.id.book);
        batch = findViewById(R.id.batch);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.botthom_anim);

        //set Animations on elements
        appname.animate().translationY(-300).setDuration(600).setStartDelay(0);
        slogan.animate().translationY(-270).setDuration(600).setStartDelay(0);
        batch.animate().setStartDelay(3500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(SplashScreen.this, MsAuthPage.class);
                    startActivity(intent);
                    finish();

            }
        }, SPLASH_TIMER);

    }
}