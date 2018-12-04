package com.example.junhee.basicintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView inputTv;
    private Button inputBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //findViewById
        inputTv = (TextView)findViewById(R.id.inputTv);
        inputBtn = (Button) findViewById(R.id.inputBtn);

        //ready for getting data
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //get data and draw
        String data = extras.getString("kojunhee");
        inputTv.setText(data);

        //listener
        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText editText= (EditText) findViewById(R.id.inputTv);
                String string = editText.getText().toString();
                intent.putExtra("returnkey", string);

                //현재 액티비티를 startActivityForResult 로 실행한 호출 액티비티에게 결과 값을 전달하게 됩니다.
                //여기에서 RESULT_OK 를 결과 상태로 알려줘서 연산이 정상적으로 완료 되었다는 것을 전달해줍니다
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
