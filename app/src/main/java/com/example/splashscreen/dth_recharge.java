package com.example.splashscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class dth_recharge extends AppCompatActivity implements View.OnClickListener {
    RecyclerView Recyclerarea_circle;
    TextView tvbottomhedding;
    RelativeLayout rl_dthoperator;
    private BottomSheetDialog Opretordialog;
    private BottomSheetDialog infodialog;
    TextView txt_dth_opretor;
    ImageView unchecked1;
    LinearLayout ll_check1;
    ImageView unchecked2;
    LinearLayout ll_check2;
    ImageView unchecked3;
    LinearLayout ll_check3;
    ImageView unchecked4;
    LinearLayout ll_check4;
    LinearLayout ll_checked;
    ImageView img_walletecheckbox;
    TextView tv_mobile_number;
    TextView tvUserName;
    TextView tvFirst_letter;
    TextView dthinfo;
    private Toolbar mToolbar;
    private RecyclerView Recyclerarea_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dth_recharge);
        setIDS();
        ClickListener();
        dth_opretor_bottomsheet();dth_info_bottomsheet();
    }
    public void setIDS(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);// will remove all possible our aactivity's window bounds
        }
        mToolbar = findViewById(R.id.toolbar);
        txt_dth_opretor = findViewById(R.id.txt_dth_opretor);
        rl_dthoperator = findViewById(R.id.rl_dthoperator);
        ll_checked = findViewById(R.id.ll_checked);
        unchecked1 = findViewById(R.id.unchecked1);
        ll_check1 = findViewById(R.id.ll_check1);
        unchecked2 = findViewById(R.id.unchecked2);
        ll_check2 = findViewById(R.id.ll_check2);
        unchecked3 = findViewById(R.id.unchecked3);
        ll_check3 = findViewById(R.id.ll_check3);
        unchecked4 = findViewById(R.id.unchecked4);
        ll_check4 = findViewById(R.id.ll_check4);
        tv_mobile_number = findViewById(R.id.tv_mobile_number);

        img_walletecheckbox = findViewById(R.id.img_walletecheckbox);
        dthinfo = findViewById(R.id.dthinfo);

    }
    private void ClickListener(){
        rl_dthoperator.setOnClickListener(this);

        img_walletecheckbox.setOnClickListener(this);
        ll_checked.setOnClickListener(this);
        unchecked1.setOnClickListener(this);
        ll_check1.setOnClickListener(this);
        unchecked2.setOnClickListener(this);
        unchecked3.setOnClickListener(this);
        unchecked4.setOnClickListener(this);
        ll_check2.setOnClickListener(this);
        ll_check3.setOnClickListener(this);
        ll_check4.setOnClickListener(this);
        dthinfo.setOnClickListener(this);

    }
    public void dth_opretor_bottomsheet() {
        View opretor_bottomsheet = getLayoutInflater().inflate(R.layout.layout_mobile_area_circle, null);
// circleArea();
        Recyclerarea_circle =(RecyclerView)opretor_bottomsheet.findViewById(R.id.Recyclerarea_circle);
        tvbottomhedding = (TextView)opretor_bottomsheet.findViewById(R.id.tvbottomhedding);

        tvbottomhedding.setText(txt_dth_opretor.getText().toString());


// View view = ((FragmentActivity)this).getLayoutInflater().inflate(R.layout.layout_mobile_area_circle, null);
        Opretordialog = new BottomSheetDialog(this);
        Opretordialog.setContentView(opretor_bottomsheet);

    }
    public void dth_info_bottomsheet() {
        View opretor_bottomsheet = getLayoutInflater().inflate(R.layout.layout_dth_bottom_info, null);
// circleArea();
        Recyclerarea_info =(RecyclerView)opretor_bottomsheet.findViewById(R.id.Recyclerarea_circle);
        tvbottomhedding = (TextView)opretor_bottomsheet.findViewById(R.id.tvbottomhedding);
        tvbottomhedding.setText("InFo");

// tvbottomhedding.setText(txt_mobileOpretor.getText().toString());


// View view = ((FragmentActivity)this).getLayoutInflater().inflate(R.layout.layout_mobile_area_circle, null);
        infodialog = new BottomSheetDialog(this);
        infodialog.setContentView(opretor_bottomsheet);

    }
    public void dth_info () {
        DTH_Opretor[] myinfoData = new DTH_Opretor[]{

                new DTH_Opretor("airtel tv",R.mipmap.airtel_tv),
// new DTH_Opretor("dish tv",R.mipmap.dish_tv),
// new DTH_Opretor("reliance tv",R.mipmap.jio),
// new DTH_Opretor("sun tv",R.mipmap.sun),
// new DTH_Opretor("tata sky",R.mipmap.tata),
// new DTH_Opretor("videocon",R.mipmap.videocon),
// new DTH_Opretor("Map", android.R.drawable.ic_dialog_map),
        };

        TransAdapter adapter = new TransAdapter(myinfoData);
        Recyclerarea_info.setHasFixedSize(true);
        Recyclerarea_info.setLayoutManager(new LinearLayoutManager(this));
        Recyclerarea_info.setAdapter(adapter);

    }

    public void dth_opretor () {
        DTH_Opretor[] myopretorData = new DTH_Opretor[]{

                new DTH_Opretor("airtel tv",R.mipmap.airtel_tv),
                new DTH_Opretor("dish tv",R.mipmap.dish_tv),
                new DTH_Opretor("reliance tv",R.mipmap.jio),
                new DTH_Opretor("sun tv",R.mipmap.sun),
// new DTH_Opretor("Map","11/02/2020", android.R.drawable.ic_dialog_alert),
                new DTH_Opretor("tata sky",R.mipmap.tata),
                new DTH_Opretor("videocon",R.mipmap.videocon),
// new DTH_Opretor("Dialer", android.R.drawable.ic_dialog_dialer),
// new DTH_Opretor("Alert", android.R.drawable.ic_dialog_alert),
// new DTH_Opretor("Map", android.R.drawable.ic_dialog_map),
        };

        DthOpretorAdapter adapter = new DthOpretorAdapter(myopretorData,Opretordialog,txt_dth_opretor);
        Recyclerarea_circle.setHasFixedSize(true);
        Recyclerarea_circle.setLayoutManager(new LinearLayoutManager(this));
        Recyclerarea_circle.setAdapter(adapter);

    }
    public void setdefaultBank(){
        img_walletecheckbox.setImageResource(R.drawable.ic_radio_button_unchecked_24);
        unchecked1.setImageResource(R.drawable.ic_radio_button_unchecked_24);
        unchecked2.setImageResource(R.drawable.ic_radio_button_unchecked_24);
        unchecked3.setImageResource(R.drawable.ic_radio_button_unchecked_24);
        unchecked4.setImageResource(R.drawable.ic_radio_button_unchecked_24);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_dthoperator:
                Opretordialog.show();
                dth_opretor();
                break;
            case R.id.img_walletecheckbox :
            case R.id.ll_checked :
                setdefaultBank();
                img_walletecheckbox.setImageResource(R.drawable.ic_radio_button_checked_24);
                break;
            case R.id.unchecked1 :
            case R.id.ll_check1 :
                setdefaultBank();
                unchecked1.setImageResource(R.drawable.ic_radio_button_checked_24);
                break;
            case R.id.unchecked2 :
            case R.id.ll_check2 :
                setdefaultBank();
                unchecked2.setImageResource(R.drawable.ic_radio_button_checked_24);
                break;
            case R.id.unchecked3 :
            case R.id.ll_check3 :
                setdefaultBank();
                unchecked3.setImageResource(R.drawable.ic_radio_button_checked_24);

                break;
            case R.id.unchecked4 :
            case R.id.ll_check4 :
                setdefaultBank();
                unchecked4.setImageResource(R.drawable.ic_radio_button_checked_24);
                break;
            case R.id.dthinfo:
                infodialog.show();
                dth_info();


        }

    }
    public class DthOpretorAdapter extends RecyclerView.Adapter<DthOpretorAdapter.ViewHolder> {
        private DTH_Opretor[] listdthdata;
        private BottomSheetDialog Opretordialog;
        private TextView txt_dth_opretor;

        public DthOpretorAdapter(DTH_Opretor[] listdthdata,BottomSheetDialog Opretordialog,TextView txt_dth_opretor){

            this.listdthdata = listdthdata;
            this.Opretordialog = Opretordialog;
            this.txt_dth_opretor = txt_dth_opretor;
        }
        @Override
        public DthOpretorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.spinner_textview_new, parent, false);
            DthOpretorAdapter.ViewHolder viewHolder = new DthOpretorAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull DthOpretorAdapter.ViewHolder holder, final int position) {

            holder.tv_opretor_name.setText(listdthdata[position].getOpretor_name());

            holder.img_opretor.setImageResource(listdthdata[position].getOpretor_img());

            Log.d("TAG","hii...."+listdthdata[position].getOpretor_img());

            holder.tv_opretor_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Opretordialog.hide();
                    txt_dth_opretor.setText(listdthdata[position].getOpretor_name());
                }
            });


        }

        @Override
        public int getItemCount() {
            return listdthdata.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_opretor_name;
            ImageView img_opretor;

            public ViewHolder( View itemView) {
                super(itemView);
                this.tv_opretor_name = (TextView)itemView.findViewById(R.id.tv_opretor_name);
                this.img_opretor = (ImageView)itemView.findViewById(R.id.ivOpretorImage);
            }
        }
    }
    public class TransAdapter extends RecyclerView.Adapter<TransAdapter.ViewHolder> {
        private DTH_Opretor[] listdata;

        public TransAdapter(DTH_Opretor[] listdata){

            this.listdata = listdata;
        }
        @Override
        public TransAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.layout_dthinfo, parent, false);
            TransAdapter.ViewHolder viewHolder = new TransAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TransAdapter.ViewHolder holder, final int position) {

            holder.tv_OderId.setText(listdata[position].getOpretor_name());

            Log.d("TAG","hii...."+listdata[position].getOpretor_img());

            holder.tv_OderId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });


        }

        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_OderId;

            public ViewHolder( View itemView) {
                super(itemView);
                this.tv_OderId = (TextView)itemView.findViewById(R.id.tv_OderId);
            }
        }
    }
}
