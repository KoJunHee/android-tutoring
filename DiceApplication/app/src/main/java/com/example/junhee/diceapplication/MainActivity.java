package com.example.junhee.diceapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private Button btn_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        //listener
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1~6 까지 랜덤 숫자를 얻는다.
                Random dice = new Random();
                int result = dice.nextInt(6) + 1;
                // TextView에 표시한다.
                tv_result.setText(String.valueOf(result));
            }
        });

    }

    public void init() {
        tv_result = (TextView) findViewById(R.id.tv_result);
        btn_button = (Button) findViewById(R.id.btn_roll);
    }
}
