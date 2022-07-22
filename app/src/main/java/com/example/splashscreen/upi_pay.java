package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class upi_pay extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    private RecyclerView list_holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi_pay);
        setIds();
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

        list_holder.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        adapter = new upi_pay.MyRecyclerViewAdapter(this, animalNames);
        //adapter.setClickListener(this);
        list_holder.setAdapter(adapter);

    }

    private void setIds() {
        list_holder=findViewById(R.id.list_holder);
    }

    private static class MyRecyclerViewAdapter extends RecyclerView.Adapter<upi_pay.MyRecyclerViewAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;
        private upi_pay.MyRecyclerViewAdapter.ItemClickListener mClickListener;

        // data is passed into the constructor
        MyRecyclerViewAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public upi_pay.MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.layout_savedaccount, parent, false);
            return new upi_pay.MyRecyclerViewAdapter.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(upi_pay.MyRecyclerViewAdapter.ViewHolder holder, int position) {
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
        void setClickListener(upi_pay.MyRecyclerViewAdapter.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}