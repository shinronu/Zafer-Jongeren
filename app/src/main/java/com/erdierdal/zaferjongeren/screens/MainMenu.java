package com.erdierdal.zaferjongeren.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.erdierdal.zaferjongeren.R;


public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaferjongeren_mainmenu);
        prepare();
    }

    public void prepare() {
        TextView scrolltext = (TextView) findViewById(R.id.mainmenu_textview_in_scrollview);
        scrolltext.setText("test");
        Button activiteiten = (Button) findViewById(R.id.mainmenu_button_activiteiten);
        activiteiten.setClickable(true);
        activiteiten.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchtoactivtyscreen = new Intent(MainMenu.this, Activiteiten.class);
                MainMenu.this.startActivity(switchtoactivtyscreen);
                MainMenu.this.finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
