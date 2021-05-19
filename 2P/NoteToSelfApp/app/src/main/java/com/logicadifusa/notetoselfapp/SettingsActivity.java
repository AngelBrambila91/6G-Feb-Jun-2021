package com.logicadifusa.notetoselfapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    private boolean mShowDividers;

    @Override
    protected void onPause() {
        super.onPause();
        mEditor.commit();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mEditor = mPrefs.edit();
        mShowDividers = mPrefs.getBoolean("dividers", true);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setChecked(mShowDividers);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    mEditor.putBoolean("dividers", true);
                    mShowDividers = true;
                }
                else {
                    mEditor.putBoolean("dividers", false);
                    mShowDividers = false;
                }
            }
        });


    }
}
