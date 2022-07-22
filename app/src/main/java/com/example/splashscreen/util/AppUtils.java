package com.example.splashscreen.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;


import com.example.splashscreen.R;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.example.splashscreen.database.AppSettings;

public class AppUtils {

    static ProgressDialog progressDialog;
    public static Toast mToast;

    public static void showRequestDialog(Activity activity) {

        if (!((Activity) activity).isFinishing()) {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(activity);
                progressDialog.setCancelable(false);
                progressDialog.setMessage(activity.getString(R.string.please_wait));
                progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
                progressDialog.show();
            }
        }

    }

    public static void hideDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public static void showToastSort(Context context, String text) {
        if (mToast != null && mToast.getView().isShown()) {
            mToast.cancel();
        }
        mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static boolean isNetworkConnectedMainThred(Context ctx) {

        ConnectivityManager cm = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null)
            return false;
        else
            return true;
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            try {
                @SuppressLint("WrongConstant") InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                View view = activity.getCurrentFocus();
                if (view != null) {
                    IBinder binder = view.getWindowToken();
                    if (binder != null) {
                        inputMethodManager.hideSoftInputFromWindow(binder, 0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }


    public static String getDayTimeFormat(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY, hh:mm aaa");

        System.out.println(timestamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        System.out.println(formatter.format(calendar.getTime()));

        String ret = formatter.format(calendar.getTime());

        return ret;
    }

    public static String getDayTimeFormat2(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        formatter.format(cal.getTime()); //your formatted date here


        String ret = formatter.format(cal.getTime());

        return ret;
    }

    public static String getDayTimeFormat3(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY");
        System.out.println(timestamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        System.out.println(formatter.format(calendar.getTime()));

        String ret = formatter.format(calendar.getTime());

        return ret;
    }



    public static String getDayMonthYear(String date) {
        String day="";
        String month="";
        String datee="";
        String year="";
        try {
            DateFormat formatter = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");
            Date dt1 = formatter.parse(date);

            // //Fri Dec 14 2018 16:54:44

            DateFormat dayOfTheWeekFormat = new SimpleDateFormat("EEE");
            day = dayOfTheWeekFormat.format(dt1);
            DateFormat monthFormat = new SimpleDateFormat("MMM");
            month = monthFormat.format(dt1);
            DateFormat dateFormat = new SimpleDateFormat("dd");
            datee = dateFormat.format(dt1);
            DateFormat yearFormat = new SimpleDateFormat("yyyy");
            year = yearFormat.format(dt1);

        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

        return day+" "+month+" "+datee;
    }

    public static long getTimeStamp() {
        long time = System.currentTimeMillis();

        return time;
    }

    // GetDeviceId
    public static String getDeviceID(Context ctx) {
        return Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    public static void SettingLanguage(Context context) {
        try {
            String languageToLoad  = AppSettings.getString(AppSettings.language); // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getResources().updateConfiguration(config,context.getResources().getDisplayMetrics());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static String bitmapToBase64(Bitmap bitmap){

        Bitmap immagex = bitmap;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;

    }

    public static String getAppVersion(Context context){

        String version = "";
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
             version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;

    }

    public static String getDateCurrentTimeZone2(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");

        System.out.println(timestamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        System.out.println(formatter.format(calendar.getTime()));

        String ret = formatter.format(calendar.getTime());

        return ret;
    }

    public static String getDateCurrentTimeZone3(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("hh:mm aa");

        System.out.println(timestamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        System.out.println(formatter.format(calendar.getTime()));

        String ret = formatter.format(calendar.getTime());

        return ret;
    }


    public static String getDateCurrentTimeZone4(long timestamp) {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(timestamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        System.out.println(formatter.format(calendar.getTime()));

        String ret = formatter.format(calendar.getTime());

        return ret;
    }




}
