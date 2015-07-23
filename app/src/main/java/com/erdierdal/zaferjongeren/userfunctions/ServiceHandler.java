package com.erdierdal.zaferjongeren.userfunctions;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Shinronu on 7/4/2015.
 */
public class ServiceHandler extends IntentService{
    private static final String TAG = "MyActivity";
    public ServiceHandler(){
        super("ServiceHandler");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        Log.d(TAG, "onhandle");
        Toast.makeText(ServiceHandler.this, "Service started", Toast.LENGTH_SHORT).show();
        long endTime = System.currentTimeMillis() + 5*1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }
    }
}