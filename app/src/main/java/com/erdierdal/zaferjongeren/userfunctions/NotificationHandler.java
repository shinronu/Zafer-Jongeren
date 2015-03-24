//package com.erdierdal.zaferjongeren.userfunctions;
//
//import android.app.Activity;
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.NotificationCompat;
//import android.view.View;
//import android.widget.Button;
//
//import com.erdierdal.zaferjongeren.R;
//
///**
// * Created by Shinronu on 3/24/2015.
// */
//public class NotificationHandler extends Activity implements View.OnClickListener{
//    public Button notify;
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
//        prepare();
//    }
//
//    public void prepare(){
//        notify = (Button) findViewById(R.id.test);
//        notify.setOnClickListener(this);
//    }
//
//    public void onClick(View v){
//        Intent intent = new Intent(this, NotificationHandler.class);
//        PendingIntent pindent = new PendingIntent.getActivity(this, 0, intent, 0);
//        Notification noti = new Notification.Builder(this)
//        .setTicker("Ticker Title")
//        .setContentTitle("Content Title")
//        .setContentText("Content Text")
//        .setSmallIcon(R.drawable.icon)
//        .setContentIntent(pindent).getNotification();
//        noti.flags=Notification.FLAG_AUTO_CANCEL;
//        NotificationManager nftmng = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                nftmng.notify(0, noti);
//
////        NotificationCompat.Builder mBuilder =
////                new NotificationCompat.Builder(this)
////                        .setSmallIcon(R.drawable.icon)
////                        .setContentTitle("My notification")
////                        .setContentText("Hello World!");
////// Creates an explicit intent for an Activity in your app
////        Intent resultIntent = new Intent(this, NotificationHandler.class);
//    }
//}
