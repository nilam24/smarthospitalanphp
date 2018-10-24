package com.sourcecode.smarthospital;


import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.MalformedJsonException;
import com.sourcecode.smarthospital.pojohspital.DevicePojo;
import com.sourcecode.smarthospital.pojohspital.SensorDataPojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 10/6/2018.
 */

public class AdminDetailActivity extends AppCompatActivity {

  Button alert,allocclick,detaillist,entry;
  TextView textReading,textPatName,textWeigtPresur,textTemp,textHeatbeat;
  ApiInterface ap1;
  SensorDataPojo sensorDataPojo;
  List<SensorDataPojo>pojoList;
  String pressure,hbeat,temp;
  String namepat,patcontact;
  String docname,doccontact;
  String title;
  String admin_email;
  String token;
  DevicePojo devicePojo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Intent intent=getIntent();
        if(intent!=null)
        {
            admin_email=intent.getStringExtra("admin_email");
        }
        allocclick=(Button)findViewById(R.id.allocbtn);
        alert=(Button)findViewById(R.id.buttonAlert);
        textReading=(TextView)findViewById(R.id.textPatReading);
        textPatName=(TextView)findViewById(R.id.textPatName);
        textWeigtPresur=(TextView)findViewById(R.id.textWgt);
        textTemp=(TextView)findViewById(R.id.textTemp);
        textHeatbeat=(TextView)findViewById(R.id.textHBt);
        detaillist=(Button)findViewById(R.id.btndetaillist);
        entry=(Button)findViewById(R.id.buttonsendtoken);


        sensorDataPojo=new SensorDataPojo();
        devicePojo=new DevicePojo();
        pojoList=new ArrayList<>();
        ap1=ApiClient.getApiClient().create(ApiInterface.class);

        title=SharedPrefManager.getmInstance(getApplicationContext()).getNotification();
       // admin_email=SharedPrefManager.getmInstance(getApplicationContext()).getEmail();
        token=SharedPrefManager.getmInstance(getApplicationContext()).getDeviceToken();
        devicePojo=new DevicePojo(admin_email,token);
        JsonArray jsonArray=new JsonArray();
        jsonArray.add(admin_email);
        jsonArray.add(token);

        Log.e("",""+jsonArray.toString());



        JSONObject object=new JSONObject();
        if(object.has("admin_email")){
            try {
                admin_email=object.getString("admin_email");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if(object.has("token"))
        {
            try {
                token=object.getString("token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if((admin_email!=null)&&(token!=null)) {

            devicePojo=new DevicePojo(admin_email,token);
//            devicePojo.getAdminEmail();
//            devicePojo.getToken();
            int code = 0;

            code = sendRegistration(admin_email,token);

            Log.e("code", "" + code + admin_email + token);


        }

         // SensorManager sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        allocclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDetailActivity.this,AllocationActivity.class);
                startActivity(intent);
            }
        });

        textReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textPatName.setVisibility(View.VISIBLE);
                textWeigtPresur.setVisibility(View.VISIBLE);
                textTemp.setVisibility(View.VISIBLE);
                textHeatbeat.setVisibility(View.VISIBLE);
                textReading.setVisibility(View.GONE);

                Call<List<SensorDataPojo>>call=ap1.getSensorData();
                call.enqueue(new Callback<List<SensorDataPojo>>() {
                    @Override
                    public void onResponse(Call<List<SensorDataPojo>> call, Response<List<SensorDataPojo>> response) {
                        if(response.isSuccessful())
                        {
                           pojoList=response.body();

                           for(int i=0;i<pojoList.size();i++)
                           {
                               String pat_firstName_fileName=pojoList.get(i).getPat_firstName_fileName();
                               Log.e("title"+title,"filename=="+pat_firstName_fileName);
                               //if(pat_firstName_fileName.equals(title))
                              // {
                                   alert.setVisibility(View.VISIBLE);
                                   patcontact=pojoList.get(i).getPatContact();
                                   doccontact=pojoList.get(i).getDocContact();
                                   pressure=pojoList.get(i).getWPressure();
                                   hbeat=pojoList.get(i).getHeartBeat();
                                   temp=pojoList.get(i).getTemp();
                                       break;

                              // }
                           }
                          // namepat=sensorDataPojo.getPat_firstName_fileName();
                          // doccontact="8298669833";//   sensorDataPojo.getDocContact();
                          // patcontact="8292539206";//sensorDataPojo.getPatContact();
                          // pressure=sensorDataPojo.getWPressure();
                          // hbeat=sensorDataPojo.getHeartBeat();
                          // temp=sensorDataPojo.getTemp();
                           textPatName.setText(namepat);
                           textWeigtPresur.setText(pressure);
                           textHeatbeat.setText(hbeat);
                           textTemp.setText(temp);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SensorDataPojo>> call, Throwable t) {

                       if(call.isCanceled()){
                            t.printStackTrace();
                        }
                    }
                });

           }
        });

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String nm = textPatName.getText().toString().trim();
                    String p = textWeigtPresur.getText().toString().trim();
                    int pres = Integer.parseInt(p);
                    String h = textHeatbeat.getText().toString().trim();
                    int hb = Integer.parseInt(h);
                    String t = textTemp.getText().toString().trim();
                    int tmp = Integer.parseInt(t);

                    if ((pres > 120 && pres < 80) || (hb > 70 && hb < 50) || (tmp > 100 && tmp < 98)) {
                        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                        smsIntent.setType("vnd.android-dir/mms-sms");
                        smsIntent.putExtra("address", doccontact + ";" + patcontact);
                        smsIntent.putExtra("sound", RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
                        smsIntent.putExtra("sms_body", nm + " has following reading- P:" + pres + "  H:" + hb + "  T:" + temp);
                        startActivity(smsIntent);

                        Toast.makeText(AdminDetailActivity.this, "sms sent ", Toast.LENGTH_LONG).show();
                    }

                }catch (NumberFormatException n)
                {
                    n.printStackTrace();
                }
            }
        });

        detaillist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminDetailActivity.this,DetailDocActivity.class);
                startActivity(intent);
            }
        });

    }
    public int sendRegistration(String param1, String param2)  {
        final int[] res = {0};
        Log.e("code ", "" +  admin_email + token);

        Call<DevicePojo> pojoCall = ap1.sendRegistration(param1,param2);
        pojoCall.enqueue(new Callback<DevicePojo>() {
            @Override
            public void onResponse(Call<DevicePojo> call, Response<DevicePojo> response) {

                response.body();

                res[0] = response.code();
                Log.e("code==", "" + res);

            }

            @Override
            public void onFailure(Call<DevicePojo> call, Throwable t) {

                t.printStackTrace();
            }
        });

        return res[0];
    }

}




/*
 Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
49

50
        // intent triggered, you can add other intent for other actions
51
        Intent intent = new Intent(MainActivity.this, NotificationReceiver.class);
52
        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
53

54
        // this is it, we'll build the notification!
55
        // in the addAction method, if you don't want any icon, just set the first param to 0
56
        Notification mNotification = new Notification.Builder(this)
57

58
            .setContentTitle("New Post!")
59
            .setContentText("Here's an awesome update for you!")
60
            .setSmallIcon(R.drawable.ninja)
61
            .setContentIntent(pIntent)
62
            .setSound(soundUri)
63

64
            .addAction(R.drawable.ninja, "View", pIntent)
65
            .addAction(0, "Remind", pIntent)
66

67
            .build();
68

69
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
70

71
        // If you want to hide the notification after it was selected, do the code below
72
        // myNotification.flags |= Notification.FLAG_AUTO_CANCEL;
73

74
        notificationManager.notify(0, mNotification);
75
    }
76

77
    public void cancelNotification(int notificationId){
78

79
        if (Context.NOTIFICATION_SERVICE!=null) {
80
            String ns = Context.NOTIFICATION_SERVICE;
81
            NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
82
            nMgr.cancel(notificationId);
83
        }
84
    }

 */


//------------------------
