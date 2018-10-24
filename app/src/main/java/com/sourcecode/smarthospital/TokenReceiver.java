
package com.sourcecode.smarthospital;


import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.sourcecode.smarthospital.pojohspital.AdminPojo;
import com.sourcecode.smarthospital.pojohspital.DevicePojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 10/6/2018.
 */

public class TokenReceiver extends FirebaseInstanceIdService {

    String mypreference="com.sourcecode.smarthospital/mypreference";
    List<AdminPojo>pojoList;
    String email;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        pojoList=new ArrayList<>();
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();


        storeToken(refreshedToken);
        int success=sendRegistrationToServer(refreshedToken);
        Log.e("",success+" Token id=="+refreshedToken);


    }

    private void storeToken(final String refreshedToken) {

       SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(refreshedToken);

        //SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(refreshedToken);

    }

    // If you want to send messages to this application instance or
    // manage this apps subscriptions on the server side, send the
    // Instance ID token to your app server.
    private int sendRegistrationToServer(String refreshedToken) {


        final int[] res = {0};
        String tokenId="";


//        if(SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(refreshedToken))
//        {
//            tokenId=SharedPrefManager.getmInstance(getApplicationContext()).getDeviceToken();
//        }
//        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
//
//        Call<DevicePojo>pojoCall=apiInterface.sendRegistrationToServer(tokenId);
//        pojoCall.enqueue(new Callback<DevicePojo>() {
//            @Override
//            public void onResponse(Call<DevicePojo> call, Response<DevicePojo> response) {
//
//                response.body();
//                res[0] =response.code();
//                Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
//
//                Log.e("",""+res);
//            }
//
//            @Override
//            public void onFailure(Call<DevicePojo> call, Throwable t) {
//
//                res[0]=0;
//                t.printStackTrace();
//                Toast.makeText(getApplicationContext(),"saved not ",Toast.LENGTH_LONG).show();
//            }
//        });

        //SharedPrefManager.getmInstance(getApplicationContext()).saveDeviceToken(refreshedToken);

        return res[0];


    }


//        String app_key="AIzaSyBZnVX9ArOr-s0N2imOlPdmbmL99aEwGas";
//
//
//        SharedPreferences preferences=getSharedPreferences(mypreference,Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=preferences.edit();
//        editor.putString("refreshedToken",refreshedToken);
//        editor.apply();




    /*  if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null){
                //---retrieve the SMS message received---
                try{
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for(int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        String msgBody = msgs[i].getMessageBody();
                    }
                }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                }
            }*/


    }

    //:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    // Token id==fMytoXrNa-o:APA91bFCuZxT09T_gRDfHmydU2b7FgmsRoPj-CdzA0vmJbKjmJPz0Mn4U2hsUj_EaJlskQO0DLPjPVPsEh2yOmIpEKkLTy7sKPbV2d3mZ_uCyUoTmZihh7cYqWEpPjVJ0LKm8mTZKjVi

 //======================================TOKEN_ID=========================================================================
    //D/FA: Logging event (FE): screen_view(_vs), Bundle[{firebase_event_origin(_o)=auto,
// firebase_previous_class(_pc)=RegistrationAdminActivity,
// firebase_previous_id(_pi)=370937371672949229, firebase_screen_class(_sc)=AdminActivity,
// firebase_screen_id(_si)=370937371672949228}]