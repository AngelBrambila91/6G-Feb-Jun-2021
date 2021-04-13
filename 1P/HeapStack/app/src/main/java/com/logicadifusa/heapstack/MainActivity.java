package com.logicadifusa.heapstack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // int variable to hold a value
    private int value = 0;
    // Buttons and TextView
    private Button btnAdd;
    private Button btnTake;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Wiring Up
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnTake = (Button)findViewById(R.id.btnTake);
        btnGrow = (Button)findViewById(R.id.btnGrow);
        btnShrink = (Button)findViewById(R.id.btnShrink);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnHide = (Button)findViewById(R.id.btnHide);
        txtValue =(TextView)findViewById(R.id.txtValue);


        // Listeners
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        txtValue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // A local variable
        float size;

        switch (view.getId()){
            case R.id.btnAdd :
                value ++;
                txtValue.setText("" +  value);
                break;

            case R.id.btnTake:
                value --;
                txtValue.setText("" +  value);
                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText("" + value);
                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);
                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);
                break;

            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE) {
                    // Currently visible ... so ... hide it
                    txtValue.setVisibility(View.INVISIBLE);
                    btnHide.setText("SHOW");
                } else {
                    // Currently hide ... so ... show it ...
                    txtValue.setVisibility(View.VISIBLE);
                    btnHide.setText("HIDE");
                }
                break;

        }

    }
}