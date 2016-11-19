package com.example.gurjap.dailyexerciseapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class SplashScreen extends AppCompatActivity {
ImageView view;
ProgressBar progress;
Runnable runnable;
    int jumptime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        progress= (ProgressBar) findViewById(R.id.progressBar);
        progress=new ProgressBar(SplashScreen.this);
        progress.setIndeterminate(true);
        progress.setMax(100);
       // progress.setProgress(0);
   /*
        final ProgressDialog mydailog=new ProgressDialog(SplashScreen.this);
        mydailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mydailog.setMessage("Loading....");
        mydailog.setIndeterminate(true);
        mydailog.show();;
*/

        final Handler handler=new Handler();
        final int maxtime=100;
        runnable=new Runnable() {
            @Override

            public void run() {
                while(jumptime<maxtime) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                               jumptime+=10;
                                progress.setProgress(jumptime);

                    }

                    });
                }

            }
 };
        new Thread(runnable).start();
        //new
/*
//my.setVisiblity(View.INVISIBLE);
        SharedPreferences mypref= PreferenceManager.getDefaultSharedPreferences(this);
        boolean splash=mypref.getBoolean("splash",true);
        String name=mypref.getString("uname","Guest");
        Toast.makeText(SplashScreen.this, ""+name, Toast.LENGTH_SHORT).show();
        view= (ImageView) findViewById(R.id.splash_image);
        Animation myani= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        view.setAnimation(myani);
        myani.start();
 */
    }
}
