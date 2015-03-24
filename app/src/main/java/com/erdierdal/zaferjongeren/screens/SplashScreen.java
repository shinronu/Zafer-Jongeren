package com.erdierdal.zaferjongeren.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.erdierdal.zaferjongeren.R;


public class SplashScreen extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaferjongeren_splashscreen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent1 = new Intent(SplashScreen.this, MainMenu.class);
                SplashScreen.this.startActivity(intent1);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
