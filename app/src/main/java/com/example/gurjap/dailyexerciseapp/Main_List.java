package com.example.gurjap.dailyexerciseapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Main_List extends AppCompatActivity {


    public int[] name={R.string.superman_name,R.string.push_up_name,
            R.string.contralateral_limb_raises_name,R.string.bent_knee_push_up_name,
            R.string.downward_facing_dog_name,R.string.bent_knee_sit_up_name,
            R.string.push_up_with_single_leg_raise_name,R.string.front_plank_name,
            R.string.side_plank_with_bent_knee_name,R.string.supine_reverse_crunches_name,
            R.string.cobra_name,R.string.squat_jumps_name,
            R.string.forward_lunge_name,R.string.forward_lunge_with_arm_drivers_name,
            R.string.glute_activation_lunges_name,R.string.glute_bridge_name,
            R.string.hip_rotations_name,R.string.side_lunge_name,
            R.string.side_lying_hip_abduction_name,R.string.side_lying_hip_adduction_name,
            R.string.side_plank_name,R.string.side_plank_with_straight_leg_name,
            R.string.single_leg_stand_name,R.string.standing_calf_raises_wall_name,
            R.string.supine_pelvic_tilts_name

    };
    public String[] target={"Back,Butt/Hips,Shoulders","Arms, Chest,Shoulders",
            "Back,Butt/Hips,Shoulders ","Arms,Chest,Shoulders ",
            "Full Body/Integrated","not available","Arms,Butt/Hips,Chest,Shoulders",
            "Abs,Back","not avaiableble","Abs","Abs,Back","Butt/Hips,Legs-Thighs ",
            "Abs,Butt/Hips,Legs-Thighs","Abs,Butt/Hips,Legs-Thighs","Abs,Butt/Hips,Legs-Thighs"
            ,"Abs,Butt/Hips","Abs,Butt/Hips,Legs-Thighs","Butt/Hips,Legs-Thighs",
            "Butt/Hips","Butt/Hips,Legs-Thighs","Abs,Butt/Hips","Abs,Butt/Hips","Abs"
            ,"Legs-Calves and Shins","Abs"
    };
    int[] color1={R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3,R.drawable.back1,R.drawable.back2,
            R.drawable.back3};

ListView exercise_list;
    String[] name_string={"a","a","a","a","a","a","a","a","a","a",
                            "a","a","a","a","a","a","a","a","a","a",
                            "a","a","a","a","a"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main__list);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            for(int i=0;i<25;i++) name_string[i]=getString(name[i]);
            exercise_list= (ListView) findViewById(R.id.exercise_list);
            exercise_list.setAdapter(new myview(Main_List.this,android.R.layout.simple_list_item_1,name_string));
            exercise_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent godetail=new Intent(Main_List.this,Detail_page.class);
                godetail.putExtra("position",position);
                startActivity(godetail);
    }
});
    }

    class myview extends ArrayAdapter<String>
    {
            public myview(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater myinflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myrow=myinflater.inflate(R.layout.nylist_view,parent,false);
        //    RelativeLayout mylayout= new RelativeLayout(Main_List.this);
            TextView t1= (TextView) myrow.findViewById(R.id.name_exercise);
            TextView t2= (TextView) myrow.findViewById(R.id.target_part);

    t1.setText(name[position]);
            t2.setText(target[position]);
//            setContentView(mylayout);
            return myrow;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main__list, menu);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent mysetting=new Intent(this,myprefer.class);
            startActivity(mysetting);
            return true;
        }
        if (id == R.id.about) {
            Intent mysetting=new Intent(this,About_page.class);
            startActivity(mysetting);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
