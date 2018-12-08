package com.example.junhee.listviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //findViewByID
        TextView newActivityTv = (TextView) findViewById(R.id.newActivityTv);
        Button newActivityBtn = (Button) findViewById(R.id.newActivityBtn);

        // ready for getting data
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        //get data and draw
        String data = extras.getString("key");
        newActivityTv.setText(data);

        //onClickListener
        newActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("returnkey", "returnSucess");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
