package com.erdierdal.zaferjongeren.userfunctions;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.erdierdal.zaferjongeren.R;

/**
* Created by Shinronu on 3/24/2015.
*/
public class NotificationHandler extends Activity {
//   TODO class veranderen naar een notification handler die werkt op de activity scherm en als erop wordt geklikt dat die scherm wordt geopend.
//

    public Button notify;
    NotificationManager NM;
    EditText one,two,three;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        prepare();
    }

    public void prepare(){
        one = (EditText)findViewById(R.id.editText1);
        two = (EditText)findViewById(R.id.editText2);
        three = (EditText)findViewById(R.id.editText3);
    }

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
//    }

    public void notify(View vobj){
        String title = one.getText().toString();
        String subject = two.getText().toString();
        String body = three.getText().toString();
        NM=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification(android.R.drawable.
                stat_notify_more,title,System.currentTimeMillis());
        PendingIntent pending=PendingIntent.getActivity(
                getApplicationContext(),0, new Intent(),0);
        notify.setLatestEventInfo(getApplicationContext(),subject,body,pending);
        NM.notify(0, notify);
    }


}
