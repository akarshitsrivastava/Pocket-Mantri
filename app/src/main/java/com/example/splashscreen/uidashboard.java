package com.example.splashscreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreen.frag.PrepaidFrag;
import com.example.splashscreen.util.AppConstant;

import com.example.splashscreen.database.Preferences;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import pl.droidsonroids.gif.GifImageView;

public class uidashboard extends AppCompatActivity implements View.OnClickListener {
    NotificationAdapter adapter;
    ScratchAdapter scratchAdapter;
    RecyclerView rec_scratchcard;


    TextView comname , username ,   hometab , WALLET , NOTIFICATION , REWARDS  , textguide ;
    Button guidebtn ;
    Animation atg , atgtwo;
    ImageView guide , passbook , bank , pp_recharge, notification , reward_add, dth_recharge;
    String SHARED_PREFS = "sharedPrefs";
    String userCOMPLETENAME="";
    String getUserCOMPLETENAME;
    String userEMAILADDRESS="";
    String getUserEMAILADDRESS;
    String userPASSWORD="";
    String getUserPASSWORD;
    String userPHONENO="";
    String getUserPHONENO;
    private RelativeLayout innerlayout;
    private RelativeLayout innertwo;
    private RelativeLayout innerfour;
    private RelativeLayout innerfive;
    private RelativeLayout innersix;
    private LinearLayout homewalletbuttons;
    private LinearLayout walletlayout;
    private RelativeLayout innerthree;
    private GifImageView rewadscard;
    private ImageView iv_payimage;
    private ImageView iv_upi;
    private ImageView scanner,circle;
    public static final int IMAGE_CODE=1;
    Uri imageuri;
    CircleImageView circleone;
    private RecyclerView rec_notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uidashboard);

        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo= AnimationUtils.loadAnimation(this, R.anim.atgtwo);

       setIds();
        setClickListener();

        guide.startAnimation(atg);
        guidebtn.startAnimation(atgtwo);
        loadData();
        updateData();
        showScratchcard();

        homewalletbuttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setVisibility();
               showNotification();
                innertwo.setVisibility(View.VISIBLE);

            }
        });
        walletlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWALLET();
            }
        });

        rewadscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(uidashboard.this , cardrewards.class);
                startActivity(intent);
            }
        });



    }

    private void setIds() {
        comname = findViewById(R.id.comname);
        username = findViewById(R.id.username);
        innerlayout=findViewById(R.id.innerlayout);
        innertwo =findViewById(R.id.innertwo);
        innerfour =findViewById(R.id.innerfour);
        innerfive =findViewById(R.id.innerfive);


        walletlayout=findViewById(R.id.walletlayout);
        innerthree=(RelativeLayout)findViewById(R.id.innerthree);
        circle=(ImageView) findViewById(R.id.circle);
        homewalletbuttons= findViewById(R.id.homewalletbuttons);
        WALLET= findViewById(R.id.WALLET);
        NOTIFICATION =findViewById(R.id.NOTIFICATION);
        notification=findViewById(R.id.notification);
        reward_add=findViewById(R.id.reward_add);
        REWARDS=findViewById(R.id.REWARDS);
        textguide=findViewById(R.id.textguide);
        guidebtn=findViewById(R.id.guidebtn);
        guide=findViewById(R.id.guide);
        rewadscard=findViewById(R.id.rewadscard);
        iv_payimage=findViewById(R.id.iv_payimage);
        iv_upi=findViewById(R.id.iv_upi);
        scanner=findViewById(R.id.scanner);
        circleone=findViewById(R.id.circleone);
        passbook=findViewById(R.id.passbook);
        bank=findViewById(R.id.bank);
        pp_recharge=findViewById(R.id.pp_recharge);
        dth_recharge=findViewById(R.id.dth_recharge);

    }

    private void setClickListener() {
        iv_payimage.setOnClickListener(this);
        iv_upi.setOnClickListener(this);
        scanner.setOnClickListener(this);
        circle.setOnClickListener(this);
        passbook.setOnClickListener(this);
        bank.setOnClickListener(this);
        pp_recharge.setOnClickListener(this);
        notification.setOnClickListener(this);
        reward_add.setOnClickListener(this);
        dth_recharge.setOnClickListener(this);

    }

    private void updateData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        String DATA =sharedPreferences.getString(userCOMPLETENAME,"NULL");
        String DATAEMAIL =sharedPreferences.getString(userEMAILADDRESS,"NULL");


        Preferences preferences = new Preferences(this);
        Log.v("MYdATA","HI"+preferences.get(AppConstant.completeName));
        comname.setText(preferences.get(AppConstant.completeName));




    }
    private void loadData() {
        comname.setText(getUserCOMPLETENAME);
         username.setText(getUserEMAILADDRESS);

    }
    private void setWALLET(){
        setVisibility();
        innerthree.setVisibility(View.VISIBLE);

    }
    private void setNotification1(){
        setVisibility();
        innerfour.setVisibility(View.VISIBLE);

    }

    private void setScratch(){
        setVisibility();
        innerfive.setVisibility(View.VISIBLE);

    }

    private void setVisibility() {
        innerthree.setVisibility(View.GONE);
        innerlayout.setVisibility(View.GONE);
        innertwo.setVisibility(View.GONE);
        innerfour.setVisibility(View.GONE);
        innerfive.setVisibility(View.GONE);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_payimage:
                Intent intent = new Intent(uidashboard.this, Pay.class);
                startActivity(intent);
                break;
            case  R.id.iv_upi:
                Intent upi = new Intent(uidashboard.this, upi_pay.class);
                startActivity(upi);
                break;
            case  R.id.scanner:
                Intent scan = new Intent(uidashboard.this, Pay.class);
                startActivity(scan);
                break;
            case  R.id.passbook:
                Intent passb = new Intent(uidashboard.this, Passbook.class);
                startActivity(passb);
                break;
            case  R.id.bank:
                Intent bankopen = new Intent(uidashboard.this, Bank.class);
                startActivity(bankopen);
                break;
            case  R.id.pp_recharge:
                Intent prepostrech = new Intent(uidashboard.this, postpaid_prepaid.class);
                startActivity(prepostrech);
                break;
            case  R.id.notification:
                setNotification1();
                break;
            case  R.id.dth_recharge:
                Intent dth = new Intent(uidashboard.this, DTH.class);
                startActivity(dth);
                break;
             case  R.id.reward_add:
                setScratch();
                break;
              case  R.id.circle:
                selectImage();
                break;



        }
    }



    private void openimageform() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_CODE);
    }
    private void startCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMAGE_CODE && resultCode==RESULT_OK && data !=null && data.getData()!=null){

            imageuri=data.getData();

            circleone.setImageURI(imageuri);


        }
    }

    private void selectImage() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(uidashboard.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    startCamera();

                }
                else if (options[item].equals("Choose from Gallery")){
                    openimageform();
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();

                }
            }

        });
        builder.show();
    }
    private void showNotification(){
        rec_notification=findViewById(R.id.rec_notification);
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Akarshit");
        animalNames.add("Rajat");
        animalNames.add("Shubham");
        animalNames.add("Ravi");
        animalNames.add("Kapil");
        animalNames.add("Akarshit");
        animalNames.add("Rajat");
        animalNames.add("Shubham");
        animalNames.add("Ravi");
        animalNames.add("Kapil");

        rec_notification.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,true));
        adapter = new NotificationAdapter(getApplicationContext(), animalNames);
        //adapter.setClickListener(this);
        rec_notification.setAdapter(adapter);

    }
    private void showScratchcard(){
        rec_scratchcard=findViewById(R.id.rec_scratchcard);
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Akarshit");
        animalNames.add("Rajat");
        animalNames.add("Shubham");
        animalNames.add("Ravi");
        animalNames.add("Kapil");
        animalNames.add("Akarshit");
        animalNames.add("Rajat");
        animalNames.add("Shubham");
        animalNames.add("Ravi");


        int column = 3;
            rec_scratchcard.setLayoutManager(new GridLayoutManager(uidashboard.this,column));
        scratchAdapter = new ScratchAdapter(getApplicationContext(), animalNames);
        //adapter.setClickListener(this);
        rec_scratchcard.setAdapter(scratchAdapter);

    }
    private static class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;
        private NotificationAdapter.ItemClickListener mClickListener;

        // data is passed into the constructor
        NotificationAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public NotificationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.layout_savedaccount, parent, false);
            return new NotificationAdapter.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {
            String animal = mData.get(position);
            holder.myTextView.setText(animal);
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView myTextView;

            ViewHolder(View itemView) {
                super(itemView);
                myTextView = itemView.findViewById(R.id.list_acc_holder);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        // convenience method for getting data at click position
        String getItem(int id) {

            return mData.get(id);
        }

        // allows clicks events to be caught
        void setClickListener(NotificationAdapter.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
    private class ScratchAdapter extends RecyclerView.Adapter<ScratchAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;


        // data is passed into the constructor
        ScratchAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public ScratchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.scratchcard, parent, false);
            return new ScratchAdapter.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(final ScratchAdapter.ViewHolder holder, int position) {
            String animal = mData.get(position);
            holder.myTextView.setText(animal);
            holder.r_scratchmain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showLogoutDialog();

                }
            });
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder  {
            TextView myTextView;
            private RelativeLayout r_scratchmain;

            ViewHolder(View itemView) {
                super(itemView);
                myTextView = itemView.findViewById(R.id.textView);
                r_scratchmain =itemView.findViewById(R.id.r_scratchmain);

            }


        }

        // convenience method for getting data at click position
        String getItem(int id) {

            return mData.get(id);
        }

        // allows clicks events to be caught


        // parent activity will implement this method to respond to click events

    }

    private void showLogoutDialog() {


        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.scratch_dailog);
        dialog.show();


        }








    }

