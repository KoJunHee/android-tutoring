package com.example.junhee.listviewapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById
        listview = (ListView) findViewById(R.id.listview);
        Button result_button = (Button) findViewById(R.id.result_button);

        //데이터를 저장하게 되는 리스트
        List<String> list = new ArrayList<>();

        //리스트뷰와 리스트를 연결하기 위해 사용되는 어댑터
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);

        //리스트뷰의 어댑터를 지정해준다.
        listview.setAdapter(adapter);

        //리스트뷰에 보여질 아이템을 추가
        list.add("사과");
        list.add("배");
        list.add("귤");
        list.add("바나나");
        list.add("추가");
        list.add("사과");
        list.add("배");
        list.add("귤");
        list.add("바나나");
        list.add("추가");
        list.add("사과");
        list.add("배");
        list.add("귤");
        list.add("바나나");
        list.add("추가");


        //onClickListener
        result_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //리스트뷰에서 선택된 아이템의 목록을 가져온다.
                SparseBooleanArray checkedItemPositions = listview.getCheckedItemPositions();

                //선택된 아이템 담을 배열
                final List<String> selectedItems = new ArrayList<>();

                //선택된 아이템을 배열에 저장
                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    int pos = checkedItemPositions.keyAt(i);

                    if (checkedItemPositions.valueAt(i)) {
                        selectedItems.add(listview.getItemAtPosition(pos).toString());
                    }
                }

                final CharSequence[] items = selectedItems.toArray(new String[selectedItems.size()]);


                //다이얼 로그에 가져온 목록을 보여준다.
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("선택한 아이템 목록324344124");
                dialogBuilder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int pos) {
                        String selectedText = items[pos].toString();
                        Toast.makeText(MainActivity.this, selectedText, Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialogObject = dialogBuilder.create();
                alertDialogObject.show();
            }
        });

    }
}
