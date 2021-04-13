package com.logicadifusa.widgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // get Reference to all our widgets
        // Wiring Up
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final EditText editText = findViewById(R.id.editTextTextPersonName);
        final Button button = findViewById(R.id.button);
        final TextClock textClock = findViewById(R.id.textClock);
        final CheckBox cbTransparency = findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = findViewById(R.id.checkBoxTint);
        final CheckBox cbResize = findViewById(R.id.checkBoxResize);
        final ImageView imageView = findViewById(R.id.imageView);
        Switch switch1 = findViewById(R.id.switch1);
        final TextView textView = findViewById(R.id.textView);

        // Hide text at Start of app
        textView.setVisibility(View.INVISIBLE);

        // Check Boxes using anonymous class
        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cbTransparency.isChecked()) {
                    imageView.setAlpha(.1f);
                }
                else {
                    imageView.setAlpha(1f);
                }
            }
        });

        // Change Tint with second Check Box
        cbTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cbTint.isChecked()) {
                    imageView.setColorFilter(Color.argb(150,255,0,0));
                }
                else {
                    imageView.setColorFilter(Color.argb(0,0,0,0));
                }
            }
        });

        cbResize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbResize.isChecked()) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }
                else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });
    }
}