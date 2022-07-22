package com.example.splashscreen.database;

import android.app.Activity;

public final class AppSettings extends OSettings {
    public static final String PREFS_MAIN_FILE  = "PREFS_KNOSTICS_FILE";
    public static final String loginCheck = "loginCheck";
    public static final String loginId = "loginId";

    public static final String reg_id = "reg_id";
    public static final String terms_pdf = "terms_pdf";
    public static final String mobile = "mobile";
    public static final String name = "name";
    public static final String profile_image = "profile_image";
    public static final String language = "language";
    public static final String language_id = "language_id";
    public static final String image_path = "image_path";
    public static final String fcmId = "fcmId";
    public static final String notify = "notify";


    // use in pilot portal.. if my deliveries select then again open so my del will auto select
    public static final String pilotPortalSelection = "pilotPortalSelection";

    //it will chekc if date already selected in Pilot portal->mydeliveries then if press back it will show prev selected dates.
    //and if press mydeliveries or you are coming from home page it will show crrnt date
    public static final String checkSelectedDate = "checkSelectedDate";


    public static final String previousDate = "previousDate";
    public static final String currentDate = "currentDate";

    public AppSettings(Activity mActivity) {
        super(mActivity);
    }
}
