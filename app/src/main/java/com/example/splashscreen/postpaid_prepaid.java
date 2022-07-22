package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.splashscreen.frag.PostpaidFrag;
import com.example.splashscreen.frag.PrepaidFrag;
import com.example.splashscreen.util.AppUtils;

public class postpaid_prepaid extends AppCompatActivity {

    private int backFrag=0;
     Fragment fragment;
     RadioButton radioButton ,radioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpaid_prepaid);
        displayView(2);
        setId();
        setClickListener();
        radioButton2.setChecked(true);

    }

    private void setClickListener() {
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.v("akarshit", "good");
                    displayView(1);

                } else {
                    Log.v("akarshit", "bad");
                    displayView(2);
                }
            }
        });
    }



    private void setId() {
        radioButton=findViewById(R.id.radioButton);
        radioButton2=findViewById(R.id.radioButton2);

    }

    public void displayView(int position) {

        switch (position) {

            case 1:
                backFrag = 0;

                fragment = new PrepaidFrag();
// fragment = new WLogin();


                break;
            case 2:
                backFrag = 1;
                fragment = new PostpaidFrag();
// fragment = new WLogin();
                break;


            default:
                Toast.makeText(getApplicationContext(), "Comming Soon", Toast.LENGTH_LONG).show();
                break;
        }


        if (fragment != null) {

            AppUtils.hideSoftKeyboard(postpaid_prepaid.this);

            FragmentManager fragmentManager = getSupportFragmentManager();

// fragmentManager.popBackStack(fragment.toString(), FragmentManager.POP_BACK_STACK_INCLUSIVE);

            FragmentTransaction tx = fragmentManager.beginTransaction();

// tx.add(R.id.container,fragment).addToBackStack(fragment.toString());
            tx.replace(R.id.frag, fragment);

            tx.commit();
// ====to clear unused memory==

            System.gc();

        } else {
// error in creating fragment
            Log.e("ImageDataActivity", "Error in creating fragment");
        }
    }
}