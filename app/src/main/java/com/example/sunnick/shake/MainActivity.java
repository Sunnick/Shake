package com.example.sunnick.shake;


import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity  {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
//        this.setShakeable(false);
    }

    protected void onResume(){
        super.onResume();
    }



}
