package com.example.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CanvasPractice canvasPractice = new CanvasPractice(this);
        setContentView(canvasPractice);
    }
}
