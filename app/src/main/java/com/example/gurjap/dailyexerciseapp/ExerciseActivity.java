package com.example.gurjap.dailyexerciseapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Array;

public class ExerciseActivity extends AppCompatActivity {
    FloatingActionButton pause, replay, skip_exercise;
    TextView set, exercise_name, time_left_t, massege;
    ImageView exercise_image;
String[]  exercise_to_sent;
int[] status;
    AnimationDrawable myanimation=null;
    boolean on_off;
int i;
    int set_s;
    int pause_time;
    String exercise_name_s;
    int exercise_time_left;
    String message_at_half;
    String message_at_start;
    String message_at_pause_start;
    String message_at_pause_half;
    String message_at_pause_about_start;
    String message_for_advice;
    Runnable runnable = null;
    Runnable runnable2 = null;
    int image_resourse;
    int level;
    int time;
    int position = -1;
boolean status_timer=false;
    MediaPlayer mp;
    String[] exercise_beg = {"Superman",
            "Push Ups",
            "Contralateral limb raises",
            "Bent Knee push up",
            "Jumping",
            "Rope jumping",
            "Knee up",
            "Short Spirnt",
            "Squirt Jumps",
            "Arms Rotating",
            "Ups and Down",
            "Single Leg Stand"};
    String[] exercise_beg_pause_start = {
            "pause start",//superman
            "pause start"//push up
            , "pause start"//contralateral
            , "pause start"//bent knee 
            , "pause start"//jumping
            , "pause start"//rope jumping
            , "pause start"//kneeup
            , "pause start"//short sprint
            , "pause start"//squirt jumps
            , "pause start"//armsr rorating
            , "pause start"// ups and down
            , "pause start"};// singlw leg stand
    String[] exercise_beg_pause_half = {
            "pause half",//superman
            "pause half"//push up
            , "pause half"//contralateral
            , "pause half"//bent knee 
            , "pause half"//jumping
            , "pause half"//rope jumping
            , "pause half"//kneeup
            , "pause half"//short sprint
            , "pause half"//squirt jumps
            , "pause half"//armsr rorating
            , "pause half"// ups and down
            , "pause half"};// singlw leg stand
    String[] exercise_beg_pause_ready = {
            "pause ready",//superman
            "pause ready"//push up
            , "pause ready"//contralateral
            , "pause ready"//bent knee 
            , "pause ready"//jumping
            , "pause ready"//rope jumping
            , "pause ready"//kneeup
            , "pause ready"//short sprint
            , "pause ready"//squirt jumps
            , "pause ready"//armsr rorating
            , "pause ready"// ups and down
            , "pause ready"};// singlw leg stand

    String[] exercise_beg_exercise_start = {
            "exercise started",//superman
            "exercise started"//push up
            , "exercise started"//contralateral
            , "exercise started"//bent knee 
            , "exercise started"//jumping
            , "exercise started"//rope jumping
            , "exercise started"//kneeup
            , "exercise started"//short sprint
            , "exercise started"//squirt jumps
            , "exercise started"//armsr rorating
            , "exercise started"// ups and down
            , "exercise started"};// singlw leg stand
    String[] exercise_beg_exercise_half= {
            "exercise half",//superman
            "exercise half"//push up
            , "exercise half"//contralateral
            , "exercise half"//bent knee 
            , "exercise half"//jumping
            , "exercise half"//rope jumping
            , "exercise half"//kneeup
            , "exercise half"//short sprint
            , "exercise half"//squirt jumps
            , "exercise half"//armsr rorating
            , "exercise half"// ups and down
            , "exercise half"};// singlw leg stand
    String[] exercise_beg_advice = {
            "exercise advice",//superman
            "exercise advice"//push up
            , "exercise advice"//contralateral
            , "exercise advice"//bent knee 
            , "exercise advice"//jumping
            , "exercise advice"//rope jumping
            , "exercise advice"//kneeup
            , "exercise advice"//short sprint
            , "exercise advice"//squirt jumps
            , "exercise advice"//arms rorating
            , "exercise advice"// ups and down
            , "exercise advice"};// singlw leg stand

    int[] exercise_beg_time={
            20,//superman
            60,//pushups
            20,//contralateral
            60,//bent knee push up
            60,//jumping
            30,//rope jumping
            30,//knee ups
            30,//short spirnt
            30,//squirt jumps
            40,//Arms Rotating
            20,//ups down
            20//single leg stand
    };
    int[] exercise_beg_images = {
            R.drawable.superman,//superman
            R.drawable.push_up,///push_ups
            R.drawable.contralateral_limb_raises,//contralateral
            R.drawable.bent_knee_push_up,//bent_knee_push_up
            R.drawable.image_not,//jumping
            R.drawable.image_not,//rope_jumping
            R.drawable.image_not,//knee ups
            R.drawable.image_not,//short sprint
            R.drawable.squat_jumps,//squart jumps
            R.drawable.image_not,//Arms Rotating
            R.drawable.image_not,//upsdown
            R.drawable.single_leg_stand,//single leg stand

    };

    int[] exercise_beg_back={
            1,//superman
            0,//pushups
            1,//contralateral
            1,//bent knee push up
            0,//jumping
            0,//rope jumping
            1,//knee ups
            1,//short spirnt
            1,//squirt jumps
            0,//Arms Rotating
            1,//ups down
            0//single leg stand
    };
    int[] exercise_beg_status={
            0,//superman
            0,//pushups
            0,//contralateral
            0,//bent knee push up
            0,//jumping
            0,//rope jumping
            0,//knee ups
            0,//short spirnt
            0,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            0//single leg stand
    };
    int[] exercise_beg_butts={
            1,//superman
            0,//pushups
            1,//contralateral
            0,//bent knee push up
            0,//jumping
            0,//rope jumping
            1,//knee ups
            1,//short spirnt
            1,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            0//single leg stand
    };
    int[] exercise_beg_hips={
            1,//superman
            0,//pushups
            1,//contralateral
            0,//bent knee push up
            0,//jumping
            0,//rope jumping
            1,//knee ups
            1,//short spirnt
            1,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            0//single leg stand
    };
    int[] exercise_beg_shoulder={
            1,//superman
            1,//pushups
            1,//contralateral
            1,//bent knee push up
            0,//jumping
            0,//rope jumping
            0,//knee ups
            1,//short spirnt
            1,//squirt jumps
            1,//Arms Rotating
            0,//ups down
            0//single leg stand
    };
    int[] exercise_beg_arms={
            0,//superman
            1,//pushups
            0,//contralateral
            1,//bent knee push up
            0,//jumping
            1,//rope jumping
            0,//knee ups
            1,//short spirnt
            0,//squirt jumps
            1,//Arms Rotating
            1,//ups down
            0//single leg stand
    };
    int[] exercise_beg_abs={
            0,//superman
            0,//pushups
            0,//contralateral
            0,//bent knee push up
            1,//jumping
            1,//rope jumping
            0,//knee ups
            1,//short spirnt
            0,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            1//single leg stand
    };
    int[] exercise_beg_leg={
            0,//superman
            0,//pushups
            0,//contralateral
            0,//bent knee push up
            1,//jumping
            1,//rope jumping
            1,//knee ups
            1,//short spirnt
            0,//squirt jumps
            0,//Arms Rotating
            1,//ups down
            1//single leg stand
    };
    int[] exercise_beg_thigh={
            0,//superman
            0,//pushups
            0,//contralateral
            0,//bent knee push up
            1,//jumping
            1,//rope jumping
            1,//knee ups
            1,//short spirnt
            1,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            0//single leg stand
    };
    int[] exercise_beg_counting={
            0,//superman
            10,//pushups
            0,//contralateral
            15,//bent knee push up
            0,//jumping
            0,//rope jumping
            0,//knee ups
            1,//short spirnt
            10,//squirt jumps
            0,//Arms Rotating
            10,//ups down
            0//single leg stand
    };
    int[] exercise_beg_set_15={
            1,//superman
            1,//pushups
            1,//contralateral
            1,//bent knee push up
            1,//jumping
            1,//rope jumping
            1,//knee ups
            1,//short spirnt
            1,//squirt jumps
            1,//Arms Rotating
            1,//ups down
            1//single leg stand
    };
    int[] exercise_beg_set_30={
            3,//superman
            3,//pushups
            3,//contralateral
            3,//bent knee push up
            3,//jumping
            3,//rope jumping
            3,//knee ups
            3,//short spirnt
            3,//squirt jumps
            3,//Arms Rotating
            3,//ups down
            3//single leg stand

    };
    int[] exercise_beg_both_side={
            0,//superman
            0,//pushups
            0,//contralateral
            1,//bent knee push up
            0,//jumping
            0,//rope jumping
            0,//knee ups
            0,//short spirnt
            0,//squirt jumps
            0,//Arms Rotating
            0,//ups down
            1//single leg stand

    };
    int[] exercise_beg_pause={
            15,//superman
            15,//pushups
            15,//contralateral
            15,//bent knee push up
            15,//jumping
            15,//rope jumping
            15,//knee ups
            15,//short spirnt
            15,//squirt jumps
            15,//Arms Rotating
            15,//ups down
            15//single leg stand

    };
    String[] exercise_med={
            "Downward facing dog",
            "Push up with single leg raise",
            "Push up",
            "Front Plank",
            "Side Plank with straigth leg (hold)",
            "Short Sprint",
            "Supine Reverse Crunch",
            "Cobra",
            "Side Lunge",
            "Side lying with Hip abduction",
            "Standing Calf Raises Wall",
            "Stay on Toes with bent body"
    };

    String[] exercise_med_pause_start = {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    String[] exercise_med_pause_half= {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    String[] exercise_med_pause_ready = {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    String[] exercise_med_exercise_start= {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    String[] Exercise_med_exercise_half = {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    String[] exercise_med_exercise_advice = {
            "",//downward facing dog
            "",//push up with sigle leg leg raise
            "",//push up
            "" ,//fornt plank
            "",//side plank with straight(hold)
            "",//short sprint
            "",///supine Reverse crunch
            "",//cobra
            "",//side lunge
            "",//side lying hip abduction
            "",//standing calf Raises wall
            "",//stay on Toes with bent body
    };
    int[] exercise_med_images = {
            R.drawable.downward_facing_dog,//downward facing dog
            R.drawable.push_up_with_single_leg_raise,//push up with sigle leg leg raise
            R.drawable.push_up,//push up
            R.drawable.front_plank,//fornt plank
            R.drawable.side_plank_with_straight_leg,//side plank with straight(hold)
            R.drawable.image_not,//short sprint
            R.drawable.cruch,///supine Reverse crunch
            R.drawable.cobra,//cobra

            R.drawable.side_lunge,//side lunge
            R.drawable.side_lying_hip_abduction,//side lying hip abduction
            R.drawable.standing_calf_raises_wall,//standing calf Raises wall
            R.drawable.image_not,//stay on Toes with bent body
    };


    int[] exercise_med_time={
            40,//Downward facing dog
            60,//pushup with single leg raise
            60,//Push up
            20,//front plank
            20,//side Plank with straight leg(hold)
            40,//Short Sprint
            30,//Supine Reverse Crunch
            30,//Cobra
            20,//Side Lunge
            20,//Side Lying With Hip abduction
            30,//standing claf Raises Wall
            20//stay on Toes with Bent body
    };
    int[] exercise_med_status={
            0,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            0,//front plank
            0,//side Plank with straight leg(hold)
            0,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_back={
            1,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            1,//Supine Reverse Crunch
            1,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            1,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_butts={
            0,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            1,//Supine Reverse Crunch
            1,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            1,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_hips={
            0,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            0,//Supine Reverse Crunch
            1,//Cobra
            1,//Side Lunge
            1,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_shoulder={
            1,//Downward facing dog
            1,//pushup with single leg raise
            1,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            1//stay on Toes with Bent body
    };
    int[] exercise_med_arms={
            0,//Downward facing dog
            1,//pushup with single leg raise
            1,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_abs={
            0,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            0,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            1,//Supine Reverse Crunch
            1,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_leg={
            0,//Downward facing dog
            1,//pushup with single leg raise
            0,//Push up
            0,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            1,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_thigh={
            0,//Downward facing dog
            1,//pushup with single leg raise
            0,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            1,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_counting={
            0,//Downward facing dog
            20,//pushup with single leg raise
            20,//Push up
            0,//front plank
            0,//side Plank with straight leg(hold)
            0,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_set_15={
            1,//Downward facing dog
            1,//pushup with single leg raise
            1,//Push up
            1,//front plank
            1,//side Plank with straight leg(hold)
            1,//Short Sprint
            1,//Supine Reverse Crunch
            1,//Cobra
            1,//Side Lunge
            1,//Side Lying With Hip abduction
            1,//standing claf Raises Wall
            1//stay on Toes with Bent body
    };
    int[] exercise_med_set_30={
            3,//Downward facing dog
            3,//pushup with single leg raise
            3,//Push up
            3,//front plank
            3,//side Plank with straight leg(hold)
            3,//Short Sprint
            3,//Supine Reverse Crunch
            3,//Cobra
            3,//Side Lunge
            3,//Side Lying With Hip abduction
            3,//standing claf Raises Wall
            3//stay on Toes with Bent body
    };
    int[] exercise_med_both_side={
            0,//Downward facing dog
            0,//pushup with single leg raise
            0,//Push up
            0,//front plank
            0,//side Plank with straight leg(hold)
            0,//Short Sprint
            0,//Supine Reverse Crunch
            0,//Cobra
            0,//Side Lunge
            0,//Side Lying With Hip abduction
            0,//standing claf Raises Wall
            0//stay on Toes with Bent body
    };
    int[] exercise_med_pause={
            30,//Downward facing dog
            30,//pushup with single leg raise
            30,//Push up
            30,//front plank
            30,//side Plank with straight leg(hold)
            30,//Short Sprint
            30,//Supine Reverse Crunch
            30,//Cobra
            30,//Side Lunge
            30,//Side Lying With Hip abduction
            30,//standing claf Raises Wall
            30//stay on Toes with Bent body
    };

    String[] exercise_hard_field={
            "running",
            "Long Sprint",
            "Long Step Running",
            "One Leg Jumping",
            "Long jump"
    };
int [] exercise_hard_field_images={
         R.drawable.image_not
        ,R.drawable.image_not
        ,R.drawable.image_not
        ,R.drawable.image_not
        ,R.drawable.image_not

};


    int[] exercise_hard_field_time={
            420,//running
            15,//Long Sprint
            240,//long Step Running
            30,//One Leg Jumping
            60,//Long Jump

    };
    int[] exercise_hard_field_back={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_butts={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_hips={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_shoulder={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_arms={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_abs={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_leg={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_thigh={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_counting={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_set_15={
            1,//running
            1,//Long Sprint
            1,//long Step Running
            1,//One Leg Jumping
            1,//Long Jump

    };
    int[] exercise_hard_field_set_30={
            2,//running
            2,//Long Sprint
            2,//long Step Running
            2,//One Leg Jumping
            2,//Long Jump


    };
    int[] exercise_hard_field_both_side={
            0,//running
            0,//Long Sprint
            0,//long Step Running
            0,//One Leg Jumping
            0,//Long Jump

    };
    int[] exercise_hard_field_pause={
            20,//running
            20,//Long Sprint
            20,//long Step Running
            20,//One Leg Jumping
            20,//Long Jump

    };

    String[] exercise_hard_abdomonal={
            "Side lying Hip adduction",
            "Side Plank with Rotating Hips",
            "Bent knee leg Raises",
            "Crunch claps",
            "Toe Touches",
            "Bicycles Crunches",
            "Mountain Climber",
            "Seated Crisscross"
    };

    int [] exercise_hard_adomonal_images={
            R.drawable.side_lying_hip_adduction//side lying hip adduction
            ,R.drawable.image_not//side plank with rotation hip
            ,R.drawable.image_not,///bent kneee leg raises
            R.drawable.image_not//crunch claps
            ,R.drawable.image_not//toe touches
            ,R.drawable.image_not//bicycle crunches
            ,R.drawable.image_not//mountain climber
            ,R.drawable.image_not//seated crisscross

    };


    int[] exercise_hard_abdomonal_time={
            30,//side lying hip adduction
            30,//side plank with rotating hips
            20,//bent knee leg raises
            20,//crunch claps
            15,//toe touches
            15,//bicycles crunches
            20,//mountain climbers
            15,//seated crisscross


    };
    int[] exercise_hard_abdomonal_back={
            0,//side lying hip adduction
            0,//side plank with rotating hips
            1,//bent knee leg raises
            1,//crunch claps
            1,//toe touches
            1,//bicycles crunches
            1,//mountain climbers
            1//seated crisscross
    };
    int[] exercise_hard_abdomonal_butts={
            1,//side lying hip adduction
            1,//side plank with rotating hips
            1,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            1,//bicycles crunches
            1,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_abdomonal_hips={
            0,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            1,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_abdomonal_shoulder={
            0,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_abdomonal_arms={

            0,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_abdomonal_abs={
            0,//side lying hip adduction
            1,//side plank with rotating hips
            1,//bent knee leg raises
            1,//crunch claps
            1,//toe touches
            1,//bicycles crunches
            1,//mountain climbers
            1,//seated crisscross
    };
    int[] exercise_hard_abdomonal_leg={
            1,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            1,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            1,//seated crisscross
    };
    int[] exercise_hard_abdomonal_thigh={
            1,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            1,//seated crisscross
    };
    int[] exercise_hard_abdomonal_counting={
            0,//side lying hip adduction
            0,//side plank with rotating hips
            20,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_abdomonal_set_15={
            2,//side lying hip adduction
            2,//side plank with rotating hips
            2,//bent knee leg raises
            2,//crunch claps
            2,//toe touches
            2,//bicycles crunches
            2,//mountain climbers
            2,//seated crisscross
    };
    int[] exercise_hard_abdomonal_set_30={
            3,//side lying hip adduction
            3,//side plank with rotating hips
            3,//bent knee leg raises
            3,//crunch claps
            3,//toe touches
            3,//bicycles crunches
            3,//mountain climbers
            3,//seated crisscross
    };
    int[] exercise_hard_abdomonal_both_side={
            0,//side lying hip adduction
            0,//side plank with rotating hips
            0,//bent knee leg raises
            0,//crunch claps
            0,//toe touches
            0,//bicycles crunches
            0,//mountain climbers
            0,//seated crisscross
    };
    int[] exercise_hard_adomonal_pause={
            20,//side lying hip adduction
            20,//side plank with rotating hips
            20,//bent knee leg raises
            20,//crunch claps
            20,//toe touches
            20,//bicycles crunches
            20,//mountain climbers
            20,//seated crisscross

    };

    String[] exercise_hard_weight={

            "Shoulder press"
            ,"Half squart"
            ,"Dumbels fltes"
            ,"Up-Right Row Shoulder"
            ,"Biceps curl"
            ,"Triceps Stretch"
            ,"Alternate dumbles bell curl"
            ,"Wrist Crul"
            ,"Dead lift"
            ,"Bench Press"

    };
int[] exercise_hard_weight_images={
        R.drawable.image_not//shoulder press
                ,R.drawable.image_not//half squar
                ,R.drawable.image_not//dumbles fltes
                ,R.drawable.image_not//up-right row shoulder
                ,R.drawable.image_not//biceps curl
                ,R.drawable.image_not//Triceps Stretch
                ,R.drawable.image_not//Alternate dumbles bell curl
                ,R.drawable.image_not//wrist curl
                ,R.drawable.image_not//dead lift
                ,R.drawable.image_not//bench press


};
    int[] exercise_hard_weight_time={
            30,//Shoulder press
            30,//Half Squart
            30,//Dumbels_fltes
            20,//up-right row shoulder
            20,//biceps curl
            20,//triceps
            30,//Alternate dumbles bell curl
            30,//Wrist Curl
            30,//dead Lift
            30,//Bench press
    };
    int[] exercise_hard_weight_back={
            0,//Shoulder press
            1,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            1,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_butts={
            0,//Shoulder press
            1,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_hips={
            1,//Shoulder press
            1,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            1,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_shoulder={
            1,//Shoulder press
            0,//Half Squart
            1,//Dumbels_fltes
            1,//up-right row shoulder
            1,//biceps curl
            0,//triceps
            1,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            1,//Bench press
    };
    int[] exercise_hard_weight_arms={
            1,//Shoulder press
            0,//Half Squart
            1,//Dumbels_fltes
            1,//up-right row shoulder
            1,//biceps curl
            1,//triceps
            1,//Alternate dumbles bell curl
            1,//Wrist Curl
            0,//dead Lift
            1,//Bench press
    };
    int[] exercise_hard_weight_abs={
            0,//Shoulder press
            0,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_leg={
            0,//Shoulder press
            0,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_thigh={
            0,//Shoulder press
            0,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_counting={
            20,//Shoulder press
            20,//Half Squart
            20,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_set_15={
            2,//Shoulder press
            2,//Half Squart
            2,//Dumbels_fltes
            2,//up-right row shoulder
            2,//biceps curl
            2,//triceps
            2,//Alternate dumbles bell curl
            2,//Wrist Curl
            2,//dead Lift
            2,//Bench press
    };
    int[] exercise_hard_weight_set_30={
            3,//Shoulder press
            3,//Half Squart
            3,//Dumbels_fltes
            3,//up-right row shoulder
            3,//biceps curl
            3,//triceps
            3,//Alternate dumbles bell curl
            3,//Wrist Curl
            3,//dead Lift
            3,//Bench press
    };
    int[] exercise_hard_weight_both_side={
            0,//Shoulder press
            0,//Half Squart
            0,//Dumbels_fltes
            0,//up-right row shoulder
            0,//biceps curl
            0,//triceps
            0,//Alternate dumbles bell curl
            0,//Wrist Curl
            0,//dead Lift
            0,//Bench press
    };
    int[] exercise_hard_weight_pause={
            20,//Shoulder press
            20,//Half Squart
            20,//Dumbels_fltes
            20,//up-right row shoulder
            20,//biceps curl
            20,//triceps
            20,//Alternate dumbles bell curl
            20,//Wrist Curl
            20,//dead Lift
            20,//Bench press

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        exercise_name= (TextView) findViewById(R.id.exercise_name_ex);
        set= (TextView) findViewById(R.id.set_number);
        exercise_image= (ImageView) findViewById(R.id.exercise_doing_img);
        massege= (TextView) findViewById(R.id.exercise_message);
        time_left_t= (TextView) findViewById(R.id.time_left);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().getExtras().getInt("level")!=0) {
            level = getIntent().getExtras().getInt("level");
//     time=getIntent().getExtras().getInt("time");

            if(level==1)status=exercise_beg_status;
            else if (level==2)status=exercise_med_status;
        }
        if(getIntent().getExtras().getInt("position")!=0) {
            position = getIntent().getExtras().getInt("position");
            position--;
//     time=getIntent().getExtras().getInt("time");
        }


        replay = (FloatingActionButton) findViewById(R.id.replay);

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
replay.setEnabled(false);
                replay.hide();
                if(position>=0)position--;
                on_off=false;
                final Handler handler2=new Handler();
                runnable2=new Runnable(){

                    @Override
                    public void run() {
                        while (status_timer);

                        handler2.post(new Runnable() {
                            @Override
                            public void run() {
                                select_next(); pause.show();pause.setEnabled(true);
                            }
                        });

                    }
                };
                new Thread(runnable2).start();



            }
        });
        pause = (FloatingActionButton) findViewById(R.id.pause_time);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause.setEnabled(false);
                pause.hide();
                on_off=false;

                final Handler handler2=new Handler();
                runnable2=new Runnable(){

                    @Override
                    public void run() {
                        while (status_timer);
                        handler2.post(new Runnable() {
                            @Override
                            public void run() {
                                replay.show();
replay.setEnabled(true);
                            }
                        });

                    }
                };
                new Thread(runnable2).start();



                if(myanimation!=null&&myanimation.isRunning())myanimation.stop();
            }
        });
replay.hide();

        skip_exercise = (FloatingActionButton) findViewById(R.id.skip_exercise);
        skip_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
      skip_exercise.setEnabled(false);
        on_off=false;

                final Handler handler2=new Handler();
                runnable2=new Runnable(){

                    @Override
                    public void run() {
                  while (status_timer);
                        handler2.post(new Runnable() {
                            @Override
                            public void run() {
                                select_next();skip_exercise.setEnabled(true);
                            }
                        });
                    }
                };
                new Thread(runnable2).start();

            }
        });

select_next();
    }

    void timer(){
status_timer=true;
        final Handler handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run()
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                        exercise_name.setText(exercise_name_s);
                        exercise_image.setBackgroundResource(image_resourse);
                        myanimation = (AnimationDrawable) exercise_image.getBackground();
                        if (myanimation.isRunning()) {
                            myanimation.stop();
                        }
                        myanimation.start();
                    }});

                for(i=pause_time;i>0;i--)
                {

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            if(on_off) {
                                if ((pause_time / 2) < i) massege.setText(message_at_pause_start);
                                else if ((pause_time / 2) > i && i > 4)
                                    massege.setText(message_at_pause_half);
                                else if (i < 4 && i >= 1)
                                    massege.setText(message_at_pause_about_start);
                                if (i == 3) sound(R.raw.start);

                                time_left_t.setText(String.valueOf(i));

                            }        }});
                    if(on_off) {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

                for(i=exercise_time_left;i>=0;i--)
                {
                    if (on_off) {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (i == 1) sound(R.raw.stop);
                                if ((exercise_time_left / 2) < i) massege.setText(message_at_start);
                                else if ((exercise_time_left / 2) > i && i > 4)
                                    massege.setText(message_at_half);
                                else if (i < 4 && i >= 1)
                                    massege.setText(message_for_advice);
                                time_left_t.setText(String.valueOf(i));

                            }
                        });
                        if (on_off) {

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                 handler.post(new Runnable() {
                    @Override
                    public void run() {
                                              if(on_off) {

                                                  status[position]=1;
                                                  select_next();
                                              }
                        else status_timer=false;
                    }
                });
            }
        };
        new Thread(runnable).start();
    }
void sound(int x){

    if (mp != null && mp.isPlaying()){
        mp.stop();
        mp.reset();
    }
    mp = MediaPlayer.create(ExerciseActivity.this, x);
    Vibrator v = (Vibrator) getSystemService(ExerciseActivity.this.VIBRATOR_SERVICE);

    v.vibrate(400);
    mp.start();
}
    void select_next(){
        on_off=false;

        int max_position;

        position++;
    switch (level)
    {
        case 1:
        {
                 max_position=Array.getLength(exercise_beg);
                if(position<max_position){

                    exercise_to_sent=exercise_beg;
                        exercise_name_s=exercise_beg[position];
                        exercise_time_left=exercise_beg_time[position];
                        image_resourse=exercise_beg_images[position];
                        pause_time=exercise_beg_pause[position];
                        message_at_pause_start=exercise_beg_pause_start[position];
                        message_at_pause_half=exercise_beg_pause_half[position];
                        message_at_pause_about_start=exercise_beg_pause_ready[position];



                    if(exercise_beg_counting[position]>0)message_at_start="Do "+exercise_beg_counting[position]+" in "+exercise_time_left;
                        else message_at_start=exercise_beg_exercise_start[position];
                    if(exercise_beg_both_side[position]>0) message_at_half="Now Change the side";
                       else message_at_half=exercise_beg_exercise_half[position];
                        message_for_advice=exercise_beg_advice[position];

                       on_off=true;
                    timer();

                }


        }break;
        case 2:

        {
            max_position=Array.getLength(exercise_med);
            if(position<max_position){
                exercise_to_sent=exercise_med;
                exercise_name_s=exercise_med[position];
                exercise_time_left=exercise_med_time[position];
                image_resourse=exercise_med_images[position];
                message_at_pause_start=exercise_med_pause_start[position];
                message_at_pause_half=exercise_med_pause_half[position];
                message_at_pause_about_start=exercise_med_pause_ready[position];
                pause_time=exercise_med_pause[position];
                if(exercise_med_counting[position]>0)message_at_start="Do "+exercise_med_counting[position]+" in "+exercise_time_left;
                else  message_at_start=exercise_med_exercise_start[position];
                if(exercise_med_both_side[position]>0) message_at_half="Now Change the side";
              else  message_at_half=exercise_beg_exercise_half[position];
                message_for_advice=exercise_med_exercise_advice[position];
               on_off=true;
                timer();
  }
        }break;

    }
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder mybulider=new AlertDialog.Builder(this);
        mybulider.setTitle("Confirm?");
        mybulider.setMessage("Do you want to stop Exercise");
        mybulider.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ExerciseActivity.super.onBackPressed();
            }
        });
        mybulider.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog mydialog=mybulider.create();
        mydialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
      return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.toString().equals("anything"))
        {
        /*    Intent myintent=new Intent(this,Status_activity.class);
            myintent.putExtra("exercisenames",exercise_to_sent);
            myintent.putExtra("status",status);

            startActivity(myintent);
        */}
        else if(item.getItemId()==R.id.status_activity)
        {
            Intent myintent=new Intent(this,Status_activity.class);
            myintent.putExtra("exercisenames",exercise_to_sent);
            myintent.putExtra("status",status);
            startActivity(myintent);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        on_off=false;
        if(myanimation!=null&&myanimation.isRunning())myanimation.stop();
        super.onPause();
    }

    @Override
    protected void onResume() {

        if(position>=0)position--;
        on_off=false;
        final Handler handler2=new Handler();
        runnable2=new Runnable(){

            @Override
            public void run() {
                while (status_timer);

                handler2.post(new Runnable() {
                    @Override
                    public void run() {
                        select_next();
                    }
                });

            }
        };
        new Thread(runnable2).start();



        super.onResume();
    }

    @Override
    protected void onDestroy()
    {
        on_off=false;
        super.onDestroy();

    }
}
