package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.splashscreen.util.AppConstant;

import com.example.splashscreen.database.Preferences;

import java.util.Random;

public class SignUp extends AppCompatActivity {
    ImageView logo ;
    ImageButton googlelogo , twitterlogo , facebooklogo ;
    Animation atg , atgtwo,atgthree , atgfour,fromsmall;
    TextView signupclick;
    EditText edittextcompletename , editTextTextEmailAddress2, editTextTextPassword2 , editTextTextPassword3, editTextPhone;
    Button signup ;
    LinearLayout contentpop , overbox;
    TextView textviewsignin;
    String SHARED_PREFS = "sharedPrefs";
    String userCOMPLETENAME="";
    String getUserCOMPLETENAME;
    String userEMAILADDRESS="";
    String getUserEMAILADDRESS;
    String userPASSWORD="";
    String getUserPASSWORD;
    String userPHONENO="";
    String getUserPHONENO;


    Preferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setInit();
        pref = new Preferences(this);




    }

    private void setInit() {
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree= AnimationUtils.loadAnimation(this, R.anim.atgthree);
        atgfour= AnimationUtils.loadAnimation(this, R.anim.atgfour);
        fromsmall= AnimationUtils.loadAnimation(this, R.anim.fromsmall);

        logo=findViewById(R.id.logo);
        googlelogo=findViewById(R.id.googlelogo);
        facebooklogo=findViewById(R.id.facebooklogo);
        twitterlogo=findViewById(R.id.twitterlogo);


        signupclick=findViewById(R.id.signupclick);
        signup=findViewById(R.id.signup);
        textviewsignin=findViewById(R.id.textviewsignin);
        edittextcompletename=findViewById(R.id.edittextcompletename);
        editTextTextEmailAddress2=findViewById(R.id.editTextTextEmailAddress2);
        editTextTextPassword2=findViewById(R.id.editTextTextPassword2);
        editTextTextPassword3=findViewById(R.id.editTextTextPassword3);
        editTextPhone=findViewById(R.id.editTextPhone);
        logo.startAnimation(atg);
        googlelogo.startAnimation(atgtwo);
        twitterlogo.startAnimation(atgthree);
        facebooklogo.startAnimation(atgfour);


    }



    public void signclick(View view) {
        pref.set(AppConstant.userName,editTextTextEmailAddress2.getText().toString().trim());
       pref.set(AppConstant.completeName,edittextcompletename.getText().toString().trim());
        pref.set(AppConstant.passWord,editTextTextPassword2.getText().toString().trim());
        pref.set(AppConstant.repassWord,editTextTextPassword3.getText().toString().trim());
        pref.set(AppConstant.Phone,editTextPhone.getText().toString().trim());

       pref.commit();
       /* Intent i = new Intent(this , uidashboard.class);
        startActivity(i);
*/
        showResult();


    }
    private void showLogoutDialog() {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.show();




       RelativeLayout successfully = dialog.findViewById(R.id.successfully);
       ImageView imgDail = dialog.findViewById(R.id.imgDail);
       imgDail.setBackground(getResources().getDrawable(R.drawable.facebooklogo));
       // TextView tvLogout = dialog.findViewById(R.id.tvLogout);


        successfully.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult();
                dialog.dismiss();
            }
        });

    }
    private void showResult() {



        final Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        try {

            dialog.setContentView(R.layout.dialog_result);
            dialog.setCancelable(true);
            dialog.closeOptionsMenu();
            dialog.setCanceledOnTouchOutside(true);
            RelativeLayout successfully = dialog.findViewById(R.id.successfully);
            successfully.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(SignUp.this, LoginSignup.class));
                    dialog.dismiss();
                }
            });
            final ImageView imgDail = dialog.findViewById(R.id.imgDail);

            LottieAnimationView lav_result = dialog.findViewById(R.id.lav_result);
            dialog.show();
            lav_result.enableMergePathsForKitKatAndAbove(true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgDail.setVisibility(View.VISIBLE);
                    imgDail.startAnimation(fromsmall);


                }
            }, 2000);
            Random r = new Random();
            lav_result.setAnimation("successfull.json");



            dialog.show();
        } catch (Exception e) {
            dialog.dismiss();

        }

    }


    public void signclickone(View view) {
        startActivity(new Intent(SignUp.this , LoginSignup.class));
    }
}