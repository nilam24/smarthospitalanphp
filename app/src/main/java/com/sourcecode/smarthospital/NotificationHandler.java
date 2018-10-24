package com.sourcecode.smarthospital;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class NotificationHandler extends FirebaseMessagingService {

    Map<String,String>map;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("TAG", "From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            map=new HashMap<>();
            map=remoteMessage.getData();
            Intent intent=new Intent(getApplicationContext(),AdminDetailActivity.class);

            PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent ,PendingIntent.FLAG_UPDATE_CURRENT);
            try {
                pendingIntent.send(getApplicationContext(),0,intent);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }

        }
        if (remoteMessage.getNotification() != null) {
            Log.d("TAG", "Message Notification Body: " + remoteMessage.getNotification().getBody());
            String title=remoteMessage.getNotification().getTitle();
            String body=remoteMessage.getNotification().getBody();
            String click=remoteMessage.getNotification().getClickAction();

            SharedPrefManager.saveNotificationTitle(title);

            Log.e("title==?"+title,"");


        }

        //sendNotification();

    }

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




    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
    }

    @Override
    public void onDeletedMessages() {


    }

    @Override
    public void onSendError(String s, Exception e) {
        super.onSendError(s, e);
    }

    public NotificationHandler() {
        super();
    }
}
