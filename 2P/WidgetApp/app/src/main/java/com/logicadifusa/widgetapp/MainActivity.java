package com.logicadifusa.widgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        // get Reference to all our widgets
        // Wiring Up
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final TextClock textClock = findViewById(R.id.textClock);
        final CheckBox cbTransparency = findViewById(R.id.checkBoxTransparency);
        final CheckBox cbTint = findViewById(R.id.checkBoxTint);
        final CheckBox cbResize = findViewById(R.id.checkBoxResize);
        final ImageView imageView = findViewById(R.id.imageView);
        Switch switch1 = findViewById(R.id.switch1);
        WebView webView= findViewById(R.id.webView);

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

        // For the radio buttons
        radioGroup.clearCheck(); // uncheck all buttons
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb = radioGroup.findViewById(checkedId);
                switch (rb.getId()) {
                    case R.id.radioButtonMexico:
                        textClock.setTimeZone("America/Mexico_City");
                        break;

                    case R.id.radioButtonLondon:
                        textClock.setTimeZone("Europe/London");
                        break;

                    case R.id.radioButtonBeijing:
                        textClock.setTimeZone("Etc/GMT+8");
                        break;

                    case R.id.radioButtonNewYork:
                        textClock.setTimeZone("America/New_York");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                textView.setText(text);
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.INVISIBLE);
                    webView.loadUrl("wwww.google.com");
                }
            }
        });
    }
}