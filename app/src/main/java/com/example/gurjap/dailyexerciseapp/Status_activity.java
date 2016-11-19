package com.example.gurjap.dailyexerciseapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Status_activity extends AppCompatActivity {
ListView status_list;
    String[] names;
    int[] status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        names=getIntent().getStringArrayExtra("exercisenames");
        status=getIntent().getIntArrayExtra("status");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        status_list= (ListView) findViewById(R.id.status_exercise);

        status_list.setAdapter(new myview(Status_activity.this,android.R.layout.simple_list_item_1,names));

        status_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //            position++;
          /*      Intent myint=new Intent(Status_activity.this,ExerciseActivity.class);
                myint.putExtra("position",position);
                startActivity(myint);
                Status_activity.this.finish();
          */  }
        });

    }
    class myview extends ArrayAdapter<String>{

        public myview(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater myinflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myrow=myinflater.inflate(R.layout.status_layout,parent,false);

            TextView exercise_name1= (TextView) myrow.findViewById(R.id.exercisename1);
            ImageView status_icon= (ImageView) myrow.findViewById(R.id.exercise_done);

            exercise_name1.setText(names[position]);
            if(status[position]==0)status_icon.setImageResource(android.R.drawable.checkbox_off_background);
            return myrow;
        }
    }

}
