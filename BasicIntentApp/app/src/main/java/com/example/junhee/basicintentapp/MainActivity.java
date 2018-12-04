package com.example.junhee.basicintentapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 100;
    private Button firstBtn;
    private TextView writeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById
        writeResult = (TextView) findViewById(R.id.writeResult);
        firstBtn = (Button) findViewById(R.id.button);

        //listener
        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("kojunhee", "this is test");

                //요청 코드를 통해서 결과 값을 반환 받을 때, 내가 요청한 결과를 식별하여 처리할 수 있습니다.
                startActivityForResult(i, REQUEST_CODE);
            }
        });

    }


    //Second Activity 에서 처리된 결과를 받는 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnkey")) {
                String result_string = data.getExtras().getString("returnkey");
                if (result_string != null && result_string.length() > 0) {
                    writeResult.setText(result_string);
                }
            }
        }
    }
}
