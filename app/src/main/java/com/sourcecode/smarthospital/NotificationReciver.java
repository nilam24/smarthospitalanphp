package com.sourcecode.smarthospital;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NotificationReciver extends FirebaseMessagingService {

    int notiID = 1;
    String CHANNEL_ID;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0) {
            try {
                JSONObject jsonobj = new JSONObject(remoteMessage.getData().toString());

                sendPushNotification(jsonobj);
            } catch (Exception e) {
                e.getMessage();

            }


        }
        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        String click_action = remoteMessage.getNotification().getClickAction();

        Intent in = new Intent(getApplicationContext(), AdminDetailActivity.class);

        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        in.setAction(Intent.ACTION_OPEN_DOCUMENT);
        in.setAction(Intent.ACTION_BATTERY_LOW);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, in, PendingIntent.FLAG_UPDATE_CURRENT);
        SharedPrefManager.saveNotificationTitle(title);

        Log.e("title==reciver"+title,"");


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(message);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText("large text"));
        notificationBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.addAction(R.drawable.ic_launcher_foreground, getString(R.string.project_id), pendingIntent);

        //NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManagerCompat noti = NotificationManagerCompat.from(this);
        noti.notify(notiID, notificationBuilder.build());

        Map<String, String> map = new HashMap<>();
        map = remoteMessage.getData();


        Log.e("notification---", "" + remoteMessage.getData());

    }
//        else {
//
//       }
//
//        if(remoteMessage.getNotification()!=null){
//            remoteMessage.getNotification().getBody();
//        }
//
//    }

    private void sendPushNotification(JSONObject jsonobj) {

        Log.e("notification ==", "" + jsonobj);

//        try {
//            JSONObject data = jsonobj.getJSONObject("data");
//            String title = data.getString("");
//            String message = data.getString("message");
//            String imageurl = data.optString("image");
//
//            MyNotificationManager myNotificationManager = new MyNotificationManager(getApplicationContext());
//            Intent intent = new Intent(getApplicationContext(), AdminDetailActivity.class);
//
//            if (imageurl != null) {
//                myNotificationManager.showBigNotification(title, message, imageurl, intent);
//            } else {
//                myNotificationManager.showSmallNotification(title, message, intent);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

//
//
//private static final String TAG = "MyFirebaseMsgService";
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        if (remoteMessage.getData().size() > 0) {
//            Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());
//            try {
//                JSONObject json = new JSONObject(remoteMessage.getData().toString());
//                sendPushNotification(json);
//            } catch (Exception e) {
//                Log.e(TAG, "Exception: " + e.getMessage());
//            }
//        }
//    }

//    this method will display the notification
//    We are passing the JSONObject that is received from
//    firebase cloud messaging
//    private void sendPushNotification(JSONObject json) {
//        //optionally we can display the json into log
//        Log.e(TAG, "Notification JSON " + json.toString());
//        try {
//            //getting the json data
//            JSONObject data = json.getJSONObject("data");
//
//            //parsing json data
//            String title = data.getString("title");
//            String message = data.getString("message");
//            String imageUrl = data.getString("image");
//
//            //creating MyNotificationManager object
//            MyNotificationManager mNotificationManager = new MyNotificationManager(getApplicationContext());
//
//            //creating an intent for the notification
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//
//            //if there is no image
//            if(imageUrl.equals("null")){
//                //displaying small notification
//                mNotificationManager.showSmallNotification(title, message, intent);
//            }else{
//                //if there is an image
//                //displaying a big notification
//                mNotificationManager.showBigNotification(title, message, imageUrl, intent);
//            }
//        } catch (JSONException e) {
//            Log.e(TAG, "Json Exception: " + e.getMessage());
//        } catch (Exception e) {
//            Log.e(TAG, "Exception: " + e.getMessage());
//        }
//    }

  } //------------------------------------------------------------------------------------------------
//


/*
 // TODO(developer): Handle FCM messages here.
    // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
    Log.d(TAG, "From: " + remoteMessage.getFrom());

    // Check if message contains a data payload.
    if (remoteMessage.getData().size() > 0) {
        Log.d(TAG, "Message data payload: " + remoteMessage.getData());

        if (/* Check if data needs to be processed by long running job */// true) {
        // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
  /*      scheduleJob();
        } else {
        // Handle message within 10 seconds
        handleNow();
        }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        }
 */