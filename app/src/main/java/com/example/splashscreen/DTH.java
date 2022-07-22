package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DTH extends AppCompatActivity implements View.OnClickListener {
    Context context;
    RecyclerView recyclerView;
    Button btn_dthrecharge;
    EditText et_mobilenum;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    RecentAdapter adapter;
    private RecyclerView recentDthRecharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_h);
        initViews();
        clickListener();
        recentdthrecharge();
        etDthID();
    }
    private void initViews() {
        recyclerView = findViewById(R.id.recentDthRecharge);
        btn_dthrecharge = (Button)findViewById(R.id.btn_dthrecharge1);
        et_mobilenum = (EditText) findViewById(R.id.et_mobilenum);


    }
    public void clickListener(){
        btn_dthrecharge.setOnClickListener(this);


    }
    public void etDthID(){

        et_mobilenum.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et_mobilenum.getText().toString().trim().length()>1){

                    String mob_num = et_mobilenum.getText().toString();
                    btn_dthrecharge.setVisibility(View.VISIBLE);
                }
                else {
                    btn_dthrecharge.setVisibility(View.GONE);
                }




            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dthrecharge1:
                String mob_num = et_mobilenum.getText().toString();
               startActivity(new Intent(getApplicationContext(), dth_recharge.class));
//                overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
                break;
        }
    }
    private class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;


        // data is passed into the constructor
        RecentAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public RecentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.layout_recent_recharge, parent, false);
            return new RecentAdapter.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(final RecentAdapter.ViewHolder holder, int position) {
            String animal = mData.get(position);
            holder.myTextView.setText(animal);

        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }


        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder  {
            TextView myTextView;


            ViewHolder(View itemView) {
                super(itemView);
                myTextView = itemView.findViewById(R.id.recent_contact_name);

            }


        }

        // convenience method for getting data at click position
        String getItem(int id) {

            return mData.get(id);
        }

        // allows clicks events to be caught


        // parent activity will implement this method to respond to click events

    }
    public void recentdthrecharge(){

        recentDthRecharge=findViewById(R.id.recentDthRecharge);
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

        recentDthRecharge.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,true));
        adapter = new RecentAdapter(getApplicationContext(), animalNames);
        //adapter.setClickListener(this);
        recentDthRecharge.setAdapter(adapter);

    }
}