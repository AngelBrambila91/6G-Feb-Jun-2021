package com.logicadifusa.variablesexpressionsoperatorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    // Primitive types
    int unreadMessages = 10;
    long millisecondsElapsed = 1438161511684l;
    float accountBalance = 3400.90f;
    boolean isFriend = true;
    char contactFirstInitial = 'A';

    // Complex type
    String messageText = "Charles Babbage invented the difference engine";

    // Operators
    /*
    Binary Operators
    firstOperator + secondOperator
    -
    *
    /
    %

    Unary Operators
    ++
    --
    **
    //
    sizeof()
    typeof()
     */

    // Expression


    // Logical Operators
    /*
    & AND
    | OR
    ^ XOR
    ! NOT
     */

    // Comparsion Operators
    /*
    &&
    ||
    ^^
    ==
    !=
    >
    <
    >=
    <=
     */
    int numMessages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Destiny    Origin
        numMessages = 10;
        Log.i("numMessages", "," + numMessages);
        /*
        0000 0101
        0000 1001
        _________
        0000 0001
         */
        int result = 5 & 9;
        //boolean isTrue = (!(2+2 == 5));
        Log.i("numMessages", "" + result);

        switch (result)
        {
            case 1:
                break;
            case 2:
                Log.i("numMessages", "Hello there!");
            default:
                Log.i("numMessages", "Im Default!!");
        }

        int x = 10; // Sentinel Variable or Control Variable
        while (x > 0 /*Expression*/)
        {
            if(x == 10)
            {
                break;
            }
            x--;
        }

        int y = 1; // Sentinel Variable or Control Variable
        do {
            x++;
        }while (y <= 10);

        for (int i = 0; i < 3; i ++)
        {

        }
    }


}