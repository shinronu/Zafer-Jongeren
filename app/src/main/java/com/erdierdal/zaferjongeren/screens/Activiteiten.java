package com.erdierdal.zaferjongeren.screens;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.erdierdal.zaferjongeren.R;
import com.erdierdal.zaferjongeren.userfunctions.AnimationHandler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Shinronu on 3/16/2015.
 */
public class Activiteiten extends ActionBarActivity {
    public TextView thuesday_content;
    public TextView thuesday_title;
    public AnimationHandler animator;

    final int animation_duration = 400;
    public float alpha1 = 0;
    public float alpha2 = 1;
    public float XDelta = 150;
    public float YDelta1 = -100;
    public float YDelta2 = 25;
    public int animation_state = 0;

    public String SYer;
    public String SSaat;
    public String SKonu;
    protected String URL = "https://github.com/shinronu/sohbetler/blob/master/persembe_sohbeti.txt";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.zaferjongeren_activities);
        prepare();
        (new Data_handler()).execute();
    }
// prepare the texviews so we can use it in a global state within this class
    public void prepare(){
        thuesday_title = (TextView) findViewById(R.id.thuesday_title);
        thuesday_content = (TextView) findViewById(R.id.thuesday_content);
        thuesday_content.setVisibility(View.GONE);
        thuesday_title.setOnClickListener(animationStart);
        animator = new AnimationHandler();
    }
// add an onclicklistener which will start the animations depending on state of the content
    public OnClickListener animationStart = new OnClickListener(){
        public void onClick(View v){
            thuesday_content.setText(SYer + "\r\n" +  SSaat +  "\r\n"+ SKonu);
            if (animation_state == 0){
                thuesday_content.startAnimation(animator.animate(thuesday_content, animation_duration, alpha1, alpha2, XDelta, XDelta, YDelta1, YDelta2));
                animation_state++;
            } else {
                thuesday_content.startAnimation(animator.animate(thuesday_content, animation_duration, alpha2, alpha1, XDelta, XDelta, YDelta2, YDelta1));
                animation_state = 0;
            }
        }
    };
private class Data_handler extends AsyncTask {
    @Override
    protected Object doInBackground(Object... params) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements Plaats = doc.select("td#LC1");
            Elements Tijd = doc.select("td#LC2");
            Elements Onderwerp = doc.select("td#LC3");
            SYer = Plaats.text();
            SSaat = Tijd.text();
            SKonu = Onderwerp.text();
        }
        catch(MalformedURLException e){
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
}
