package com.example.splashscreen.frag;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.splashscreen.R;
import com.example.splashscreen.upi_pay;

import java.util.ArrayList;
import java.util.List;

public class PrepaidFrag extends Fragment {
    MyRecyclerViewAdapter adapter;


    private RecyclerView rec_recentrecharge;

    public PrepaidFrag() {
        // Required empty public constructor
    }


    public static PrepaidFrag newInstance( ) {
        PrepaidFrag fragment = new PrepaidFrag();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_prepaid, container, false);
      setId(view);
      setrecent();
      return view;

    }

    private void setId(View view) {
        rec_recentrecharge=view.findViewById(R.id.rec_recentrecharge);

    }
    private void setrecent(){
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

        rec_recentrecharge.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
        adapter = new MyRecyclerViewAdapter(getContext(), animalNames);
        //adapter.setClickListener(this);
        rec_recentrecharge.setAdapter(adapter);
    }
    private static class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;
        private MyRecyclerViewAdapter.ItemClickListener mClickListener;

        // data is passed into the constructor
        MyRecyclerViewAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.layout_savedaccount, parent, false);
            return new MyRecyclerViewAdapter.ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, int position) {
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
        void setClickListener(MyRecyclerViewAdapter.ItemClickListener itemClickListener) {
            this.mClickListener = itemClickListener;
        }

        // parent activity will implement this method to respond to click events
        public interface ItemClickListener {
            void onItemClick(View view, int position);
        }
    }
}