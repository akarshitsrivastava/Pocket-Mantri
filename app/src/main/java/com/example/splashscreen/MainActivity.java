package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=4000;
    Animation atg , atgtwo;
    ImageView logo , fun;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        logo=findViewById(R.id.logo);
        fun=findViewById(R.id.fun);
        logo.startAnimation(atg);
        fun.startAnimation(atgtwo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginSignup.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);



    }

}