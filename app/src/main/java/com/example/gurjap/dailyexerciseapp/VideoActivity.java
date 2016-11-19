package com.example.gurjap.dailyexerciseapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
/*VideoView video;
    int[] videos={R.raw.superman,
            R.raw.push_up,
            R.raw.contralateral_limb_raises,
            R.raw.bent_knee_push_up,
            R.raw.no_video,
            R.raw.bent_knee_sit_up,
            R.raw.push_up_with_single_leg_raise,
            R.raw.no_video,
            R.raw.side_plank_with_bent_knee,
            R.raw.supine_reverse_crunches,
            R.raw.cobra,R.raw.squat_jumps,
            R.raw.forward_lunge,
            R.raw.forward_lunge_with_arm_drivers,
            R.raw.no_video,
            R.raw.glute_bridge,
            R.raw.hip_rotations,
            R.raw.no_video,
            R.raw.side_lying_hip_abduction,
            R.raw.side_lying_hip_adduction,
            R.raw.side_plank,
            R.raw.side_plank_with_straight_leg,
            R.raw.single_leg_stand,
            R.raw.no_video,
            R.raw.supine_pelvic_tilts
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

  /*      video= (VideoView) findViewById(R.id.video_exercise);
        int position=getIntent().getExtras().getInt("position");

        video.setVideoURI(Uri.parse("android.resource://com.example.gurjap.dailyexerciseapp/"+ videos[position]));
        video.setMediaController(new MediaController(this));

        video.start();
  */  }
}
