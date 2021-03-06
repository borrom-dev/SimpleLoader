package com.angkorsuntrix.mindchallenge.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.angkorsuntrix.mindchallenge.R;
import com.angkorsuntrix.mindchallenge.ui.board.BoardActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, BoardActivity.class));
            }
        }, 3000);
    }
}
