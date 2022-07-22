package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class forgetpass extends AppCompatActivity {

    Button varificationbtn;
    ImageView logo, sadface;
    Animation atg , atgtwo,atgthree , atgfour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);


        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree= AnimationUtils.loadAnimation(this, R.anim.atgthree);
        atgfour= AnimationUtils.loadAnimation(this, R.anim.atgfour);
        varificationbtn=findViewById(R.id.verificationbtn);
        varificationbtn.startAnimation(atgthree);
        logo=findViewById(R.id.logo);


        logo.startAnimation(atg);

    }
    public void verificationclick(View view) {
        Intent i = new Intent(this , verification.class);
        startActivity(i);
    }
}