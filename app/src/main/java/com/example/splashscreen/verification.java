package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class verification extends AppCompatActivity {
    Button changepass;
    ImageView logo;
    Animation atg , atgtwo,atgthree , atgfour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree= AnimationUtils.loadAnimation(this, R.anim.atgthree);
        atgfour= AnimationUtils.loadAnimation(this, R.anim.atgfour);
        changepass=findViewById(R.id.changepass);
        logo=findViewById(R.id.logo);


        logo.startAnimation(atg);
        changepass.startAnimation(atgthree);
    }
    private void showLogoutDialog() {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.show();




        RelativeLayout successfully = dialog.findViewById(R.id.successfully);
        ImageView imgDail = dialog.findViewById(R.id.imgDail);
        imgDail.setBackground(getResources().getDrawable(R.drawable.passchange));
        // TextView tvLogout = dialog.findViewById(R.id.tvLogout);


        successfully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(verification.this, LoginSignup.class));
                dialog.dismiss();
            }
        });

    }


    public void signclicktwo(View view) {
        showLogoutDialog();
    }
}