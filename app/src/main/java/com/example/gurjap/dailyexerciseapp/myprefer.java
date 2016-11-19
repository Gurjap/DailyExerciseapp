package com.example.gurjap.dailyexerciseapp;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class myprefer extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypref);
    }
}
