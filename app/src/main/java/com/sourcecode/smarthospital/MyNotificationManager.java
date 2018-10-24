//package com.sourcecode.smarthospital;
//
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.support.v4.app.NotificationCompat;
//import android.text.Html;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class MyNotificationManager {
//
//    public static final int ID_BIG_NOTIFICATION = 23;
//    public static final int ID_SMALL_NOTIFICATION = 24;
//    private Context context;
//    Bitmap bitmap;
//
//    public MyNotificationManager(Context context) {
//        this.context = context;
//
//    }
//
//    public void showBigNotification(String title, String message, String url, Intent intent) {
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, ID_BIG_NOTIFICATION, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.BigPictureStyle bigPicStyle = new NotificationCompat.BigPictureStyle();
//        bigPicStyle.setBigContentTitle(title);
//        bigPicStyle.setSummaryText(Html.fromHtml(message));
//        bigPicStyle.bigPicture(getBitmapFromUrl(url));
//
//
//        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(context,"ChanelId");// Notification.EXTRA_CHANNEL_ID);
//        Notification notificationCompat = mbuilder.setAutoCancel(true)
//                .setContentIntent(pendingIntent)
//                .setContentTitle(title)
//                .setStyle(bigPicStyle)
//                .setSmallIcon(R.drawable.logo)
//                .setContentText(message).build();
//
//        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(ID_BIG_NOTIFICATION, notificationCompat);
//
//    }
//
//
//    public void showSmallNotification(String title, String message, Intent intent) {
//        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, ID_SMALL_NOTIFICATION, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"ChanelID");
//        Notification notification;
//        notification = builder.setAutoCancel(true)
//                .setContentIntent(pendingIntent2)
//                .setContentTitle("")
//                .setContentText("")
//                .setSmallIcon(R.drawable.logo)
//                .build();
//
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(ID_SMALL_NOTIFICATION, notification);
//
//    }
//
//    Bitmap getBitmapFromUrl(String strUrl) {
//
//        try {
//            URL url = new URL(strUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            return bitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//}
//
//    /*
//    private Bitmap getBitmapFromURL(String strURL) {
//        try {
//            URL url = new URL(strURL);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            return myBitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        */
//
//
////}
//
//
