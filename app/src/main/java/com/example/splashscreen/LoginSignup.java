package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginSignup extends AppCompatActivity {

    ImageView logo;
    ImageButton googlelogo , twitterlogo , facebooklogo ;
    Animation atg , atgtwo,atgthree , atgfour;
    TextView signupclick, forgetpass;
    Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);


        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree= AnimationUtils.loadAnimation(this, R.anim.atgthree);
        atgfour= AnimationUtils.loadAnimation(this, R.anim.atgfour);
        logo=findViewById(R.id.logo);
        googlelogo=findViewById(R.id.googlelogo);
        facebooklogo=findViewById(R.id.facebooklogo);
        twitterlogo=findViewById(R.id.twitterlogo);
        signupclick=findViewById(R.id.signupclick);
        signin=findViewById(R.id.signin);
        forgetpass=findViewById(R.id.forgetpass);
        logo.startAnimation(atg);
        googlelogo.startAnimation(atgtwo);
        twitterlogo.startAnimation(atgthree);
        facebooklogo.startAnimation(atgfour);

    }

    public void signupclick(View view) {
        Intent i = new Intent(this , SignUp.class);
        startActivity(i);
    }
    public void signinclick(View view) {
        Intent a = new Intent(this , uidashboard.class);
        startActivity(a);
    }
    public void forget(View view) {
        Intent intent = new Intent(this , forgetpass.class);
        startActivity(intent);
    }



}