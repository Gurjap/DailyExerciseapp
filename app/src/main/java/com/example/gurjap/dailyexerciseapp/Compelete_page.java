package com.example.gurjap.dailyexerciseapp;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Compelete_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compelete_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
/*    @Override
    public void onBackPressed() {
        final Dialog mydialog=new Dialog(this);
        mydialog.setContentView(R.layout.activity_splash_screen);
        mydialog.setTitle("confirm");
        mydialog.show();
        Typeface mytype=Typeface.createFromAsset(getAssets(),"fontname.ttf");
        t1.setTypeFace(mytype); // font code
        super.onBackPressed();

    }*/
}
