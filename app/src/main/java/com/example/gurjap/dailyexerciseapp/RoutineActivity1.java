package com.example.gurjap.dailyexerciseapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RoutineActivity1 extends AppCompatActivity {
    Spinner level,time,target;
    Button start_button;
    int time_left=6;
    TextView massage,seconds;
    Runnable runnable;
int time_send,level_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        level= (Spinner) findViewById(R.id.value_spinner);
        time= (Spinner) findViewById(R.id.time_spinner);
        start_button= (Button) findViewById(R.id.start_button);
        massage= (TextView) findViewById(R.id.message);
        seconds= (TextView) findViewById(R.id.seconds);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App is under construction ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                level_send=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            time_send=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(time_send==0||level_send==0){
                    massage.setText("Enter correctly");
                }
                else {
                    time_left=7;
                    massage.setText("Get Ready"+" Guest");
                    start_button.setEnabled(false);
                    timer();
                }


            }
        });
    }
    void timer()
    {

        final Handler handler=new Handler();

        runnable=new Runnable() {
            @Override

            public void run() {
                while (time_left>0) {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time_left--;
                    handler.post(new Runnable() {

                         @Override
                        public void run() {
                            seconds.setText(time_left + " sec");
                            if(time_left==5)massage.setText("Ready to start in");
                            if(time_left<1){
                                Intent myintent=new Intent(RoutineActivity1.this,ExerciseActivity.class);
                                myintent.putExtra("level",level_send);
                                myintent.putExtra("time",time_send);
                                startActivity(myintent);
                            }
                        }
                    });


                }

            }};
        new Thread(runnable).start();
        //new Thread(runnable).();
    }
  @Override
    protected void onResume() {
        super.onResume();
        massage.setText("");
        seconds.setText("");
        if(!start_button.isEnabled())start_button.setEnabled(true);
    }
}
