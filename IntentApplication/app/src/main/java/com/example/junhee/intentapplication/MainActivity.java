package com.example.junhee.intentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getApplicationContext(), "onCreate() 호출됨", Toast.LENGTH_LONG).show();

        // 화면이 메모리에 만들어짐
        setContentView(R.layout.activity_main);

        //findViewById
        Button button1 = (Button) findViewById(R.id.newbutton1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), NewActivity.class);
                myintent.putExtra("key", "junhee.ko");
                startActivityForResult(myintent, 1);

//                User.loginName = "junhee.ko";
//                Intent myintent2 = new Intent(getApplicationContext(), NewActivity.class);
//                startActivityForResult(myintent2, User.REQ_CODE_PHONEBOOK);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com/"));
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01063650916"));
                startActivity(intent);
            }
        });
    }


    //Second Activity 에서 처리된 결과를 받는 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data.hasExtra("returnkey")) {
                String result_string = data.getExtras().getString("returnkey");
                if (result_string != null && result_string.length() > 0) {
                    Toast.makeText(getApplicationContext(), "came back again!!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 화면 기능을 실행할 준비를 함ㅁ
        Toast.makeText(getApplicationContext(), "onStart() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 화면의 기능을 중지시키는 과정
        Toast.makeText(getApplicationContext(), "onStop() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 화면을 메모리에서 없애버른 과정
        Toast.makeText(getApplicationContext(), "onDestroy() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 화면에서 보이지 않도록 하는 과정
        // 화면의 상태를 임시 저장
        Toast.makeText(getApplicationContext(), "onPause() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 화면에 보여주기 전에 준비를 끝냄
        // 임시로 저장된 화면의 상태를 불러온다
        Toast.makeText(getApplicationContext(), "onResume() 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), "onRestart() 호출됨", Toast.LENGTH_LONG).show();
    }
}