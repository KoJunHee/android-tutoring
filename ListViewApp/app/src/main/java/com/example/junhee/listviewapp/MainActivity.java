package com.example.junhee.listviewapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<MyItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dataSetting();
    }

    private void init(){
        mListView = (ListView) findViewById(R.id.listView);
    }

    private void dataSetting() {

        // make list
        arrayList = new ArrayList<>();
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.google), "google", "fsdf"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ama), "amazon", "124214"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.apple), "apple", "htyh"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.facebook), "facebook", "tb"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ibm), "ibm", "fwe"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lg), "lg", "utut"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.naver), "naver", "nvbn"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.samsung), "samsung", "hts"));
        arrayList.add(new MyItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.toss), "toss", "436"));

        // adapter
        MyAdapter mMyAdapter = new MyAdapter(this);

        //add item in adapter
        for (int i = 0; i < arrayList.size(); i++) {
            mMyAdapter.addItem(arrayList.get(i).getIcon(), arrayList.get(i).getName(), arrayList.get(i).getContents());
        }

        // 리스트뷰에 어댑터 등록
        mListView.setAdapter(mMyAdapter);
    }
}