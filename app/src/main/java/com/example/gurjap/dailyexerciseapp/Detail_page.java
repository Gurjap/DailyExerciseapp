package com.example.gurjap.dailyexerciseapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail_page extends AppCompatActivity  {
    TextView name_t, step_1_t, step_2_t, step_3_t, step_4_t;
    int position = 0;
   ImageView imageView;
    int[] step_1 = {R.string.superman_step_1, R.string.push_up_step_1,
            R.string.contralateral_limb_raises_step_1, R.string.bent_knee_push_up_step_1,
            R.string.downward_facing_dog_step_1, R.string.bent_knee_sit_up_step_1,
            R.string.push_up_with_single_leg_raise_step_1, R.string.front_plank_step_1,
            R.string.side_plank_with_bent_knee_step_1, R.string.supine_reverse_crunches_step_1,
            R.string.cobra_step_1, R.string.squat_jumps_step_1,
            R.string.forward_lunge_step_1, R.string.forward_lunge_with_arm_drivers_step_1,
            R.string.glute_activation_lunges_step_1, R.string.glute_bridge_step_1,
            R.string.hip_rotations_step_1, R.string.side_lunge_step_1,
            R.string.side_lying_hip_abduction_step_1, R.string.side_lying_hip_adduction_step_1,
            R.string.side_plank_step_1, R.string.side_plank_with_straight_leg_step_1,
            R.string.single_leg_stand_step_1, R.string.standing_calf_raises_wall_step_1,
            R.string.supine_pelvic_tilts_step_1

    };
    int[] step_2 = {R.string.superman_step_2, R.string.push_up_step_2,
            R.string.contralateral_limb_raises_step_2, R.string.bent_knee_push_up_step_2,
            R.string.downward_facing_dog_step_2, R.string.bent_knee_sit_up_step_2,
            R.string.push_up_with_single_leg_raise_step_2, R.string.front_plank_step_2,
            R.string.side_plank_with_bent_knee_step_2, R.string.supine_reverse_crunches_step_2,
            R.string.cobra_step_2, R.string.squat_jumps_step_2,
            R.string.forward_lunge_step_2, R.string.forward_lunge_with_arm_drivers_step_2,
            R.string.glute_activation_lunges_step_2, R.string.glute_bridge_step_2,
            R.string.hip_rotations_step_2, R.string.side_lunge_step_2,
            R.string.side_lying_hip_abduction_step_2, R.string.side_lying_hip_adduction_step_2,
            R.string.side_plank_step_2, R.string.side_plank_with_straight_leg_step_2,
            R.string.single_leg_stand_step_2, R.string.standing_calf_raises_wall_step_2,
            R.string.supine_pelvic_tilts_step_2

    };

    int[] step_3 = {R.string.superman_step_3, R.string.push_up_step_3,
            R.string.contralateral_limb_raises_step_3, R.string.bent_knee_push_up_step_3,
            R.string.downward_facing_dog_step_3, R.string.bent_knee_sit_up_step_3,
            R.string.push_up_with_single_leg_raise_step_3, R.string.front_plank_step_3,
            R.string.side_plank_with_bent_knee_step_3, R.string.supine_reverse_crunches_step_3,
            R.string.cobra_step_3, R.string.squat_jumps_step_3,
            R.string.forward_lunge_step_3, R.string.forward_lunge_with_arm_drivers_step_3,
            R.string.glute_activation_lunges_step_3, R.string.glute_bridge_step_3,
            R.string.hip_rotations_step_3, R.string.side_lunge_step_3,
            R.string.side_lying_hip_abduction_step_3, R.string.side_lying_hip_adduction_step_3,
            R.string.side_plank_step_3, R.string.side_plank_with_straight_leg_step_3,
            R.string.single_leg_stand_step_3, R.string.standing_calf_raises_wall_step_3,
            R.string.supine_pelvic_tilts_step_3

    };
    int[] step_4 = {R.string.superman_step_4, R.string.push_up_step_4,
            R.string.contralateral_limb_raises_step_4, R.string.bent_knee_push_up_step_4,
            R.string.downward_facing_dog_step_4, R.string.bent_knee_sit_up_step_4,
            R.string.push_up_with_single_leg_raise_step_4, R.string.front_plank_step_4,
            R.string.side_plank_with_bent_knee_step_4, R.string.supine_reverse_crunches_step_4,
            R.string.cobra_step_4, R.string.squat_jumps_step_4,
            R.string.forward_lunge_step_4, R.string.forward_lunge_with_arm_drivers_step_4,
            R.string.glute_activation_lunges_step_4, R.string.glute_bridge_step_4,
            R.string.hip_rotations_step_4, R.string.side_lunge_step_4,
            R.string.side_lying_hip_abduction_step_4, R.string.side_lying_hip_adduction_step_4,
            R.string.side_plank_step_4, R.string.side_plank_with_straight_leg_step_4,
            R.string.single_leg_stand_step_4, R.string.standing_calf_raises_wall_step_4,
            R.string.supine_pelvic_tilts_step_4

    };


    int[] url = {R.string.superman_url, R.string.push_up_url,
            R.string.contralateral_limb_raises_url, R.string.bent_knee_push_up_url,
            R.string.downward_facing_dog_url, R.string.bent_knee_sit_up_url,
            R.string.push_up_with_single_leg_raise_url, R.string.front_plank_url,
            R.string.side_plank_with_bent_knee_url, R.string.supine_reverse_crunches_url,
            R.string.cobra_url, R.string.squat_jumps_url,
            R.string.forward_lunge_url, R.string.forward_lunge_with_arm_drivers_url,
            R.string.glute_activation_lunges_url, R.string.glute_bridge_url,
            R.string.hip_rotations_url, R.string.side_lunge_url,
            R.string.side_lying_hip_abduction_url, R.string.side_lying_hip_adduction_url,
            R.string.side_plank_url, R.string.side_plank_with_straight_leg_url,
            R.string.single_leg_stand_url, R.string.standing_calf_raises_wall_url,
            R.string.supine_pelvic_tilts_url

    };
    int s = 0;

    public int[] name = {R.string.superman_name, R.string.push_up_name,
            R.string.contralateral_limb_raises_name, R.string.bent_knee_push_up_name,
            R.string.downward_facing_dog_name, R.string.bent_knee_sit_up_name,
            R.string.push_up_with_single_leg_raise_name, R.string.front_plank_name,
            R.string.side_plank_with_bent_knee_name, R.string.supine_reverse_crunches_name,
            R.string.cobra_name, R.string.squat_jumps_name,
            R.string.forward_lunge_name, R.string.forward_lunge_with_arm_drivers_name,
            R.string.glute_activation_lunges_name, R.string.glute_bridge_name,
            R.string.hip_rotations_name, R.string.side_lunge_name,
            R.string.side_lying_hip_abduction_name, R.string.side_lying_hip_adduction_name,
            R.string.side_plank_name, R.string.side_plank_with_straight_leg_name,
            R.string.single_leg_stand_name, R.string.standing_calf_raises_wall_name,
            R.string.supine_pelvic_tilts_name

    };
    int[] images = {
            R.drawable.superman,
            R.drawable.push_up,
            R.drawable.contralateral_limb_raises,
            R.drawable.bent_knee_push_up,
            R.drawable.downward_facing_dog,
            R.drawable.image_not,
            R.drawable.push_up_with_single_leg_raise,
            R.drawable.front_plank,
            R.drawable.image_not,
            R.drawable.cruch,
            R.drawable.cobra,
            R.drawable.squat_jumps,
            R.drawable.forward_lunge,
            R.drawable.forward_lunge_with_arm_drivers,

            R.drawable.glute_activation_lunges,
            R.drawable.glute_bridge,
            R.drawable.hip_rotations,
            R.drawable.side_lunge,

            R.drawable.side_lying_hip_abduction,
            R.drawable.side_lying_hip_adduction,
            R.drawable.side_plank,
            R.drawable.side_plank_with_straight_leg,
            R.drawable.single_leg_stand,
            R.drawable.standing_calf_raises_wall,
            R.drawable.supine_pelvic_tilts


    };

/*
    int[] image_pos_1st = {0, 2, 5, 8, 11, 15, 17, 20, 22, 24, 26, 29, 34, 36, 38, 43, 45, 49, 52, 54, 56, 58, 60, 62, 66, 68};

    int number_images;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name_t = (TextView) findViewById(R.id.name_text);
        step_1_t = (TextView) findViewById(R.id.step1);
        step_2_t = (TextView) findViewById(R.id.step2);
        step_3_t = (TextView) findViewById(R.id.step3);
        step_4_t = (TextView) findViewById(R.id.step4);
        imageView = (ImageView) findViewById(R.id.exercise_image);
        position = getIntent().getExtras().getInt("position");

        name_t.setText(name[position]);
        step_1_t.setText(step_1[position]);
        step_2_t.setText(step_2[position]);
        step_3_t.setText(step_3[position]);
        step_4_t.setText(step_4[position]);


        imageView.setBackgroundResource(images[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AnimationDrawable myani= (AnimationDrawable) imageView.getBackground();
        if(myani.isRunning()){
            myani.stop();
        }
        else myani.start();
    }
});



        //imageView.setImageResource(R.drawable.bent_knee_push_up);
        FloatingActionButton search = (FloatingActionButton) findViewById(R.id.search_youtube);
        FloatingActionButton video = (FloatingActionButton) findViewById(R.id.demo_video);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mysearch = new Intent(Intent.ACTION_VIEW);
                mysearch.setData(Uri.parse(getString(url[position])));
                startActivity(mysearch);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myvideo = new Intent(Detail_page.this, VideoActivity.class);
                myvideo.putExtra("position", position);
                startActivity(myvideo);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main__list, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent mysetting=new Intent(this,Settings.class);
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

