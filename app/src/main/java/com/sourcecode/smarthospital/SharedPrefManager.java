package com.sourcecode.smarthospital;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String SHAREDPREFNAME="com.sourcecode.smarthospital.fcmsharedpref";
    private static final String TAG_TOKEN="tagtoken";
    private static final String TAG_TITLE="title";
    private static final String TAG_MES="message";
    private static final String TAG_BODY="body";

    private static SharedPrefManager mInstance;
    private static Context context;

    public SharedPrefManager(Context context) {
        this.context=context;
    }

    public static synchronized SharedPrefManager getmInstance(Context context){
        if(mInstance==null)
        {
            mInstance=new SharedPrefManager(context);
        }
        return mInstance;
    }

    public static boolean saveDeviceToken(String token)
    {
        SharedPreferences preferences=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(TAG_TOKEN,token);
        editor.apply();
        return true;

    }

    public static boolean saveNotificationTitle(String title){

        SharedPreferences pref=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("title",title);
      //  editor.putString("body",body);

        editor.apply();
        return true;
    }

    public static boolean saveEmail(String email)
    {
        if(email!=null) {
            SharedPreferences pr = context.getSharedPreferences(SHAREDPREFNAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = pr.edit();
            editor.putString("email", email);
            editor.apply();
            return true;
        }
        else return false;

    }

    public static boolean savePatName(String patname)
    {
        if(patname!=null) {
            SharedPreferences p = context.getSharedPreferences(SHAREDPREFNAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = p.edit();
            editor.putString("patname", patname);
            editor.apply();

            return true;
        }
        else return false;

    }


  public String getDeviceToken()
  {
      SharedPreferences preferences=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);
      return preferences.getString(TAG_TOKEN,null);

  }
  public String getNotification()
  {
      SharedPreferences sharedPreferences=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);

     // sharedPreferences.getString(TAG_TOKEN,null);
      return  sharedPreferences.getString(TAG_TITLE,null);
  }

  public String getEmail()
  {
      SharedPreferences sharedPref=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);
      return sharedPref.getString("email",null);

  }

  public String getPatName()
  {
      SharedPreferences sp=context.getSharedPreferences(SHAREDPREFNAME,Context.MODE_PRIVATE);
      return sp.getString("patname",null);
  }


}


