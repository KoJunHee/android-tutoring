package com.example.junhee.listviewapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<MyItem> mItems = new ArrayList<>();
    Context c;

    public MyAdapter(Context context) {
        c = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public MyItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        // inflate
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        }

        // findViewById
        ImageView iv_img = (ImageView) convertView.findViewById(R.id.iv_img);
        final TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_contents = (TextView) convertView.findViewById(R.id.tv_contents);

        // 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용
        final MyItem myItem = getItem(position);

        // 각 위젯에 세팅된 아이템을 뿌려준다
        iv_img.setImageDrawable(myItem.getIcon());
        tv_name.setText(myItem.getName());
        tv_contents.setText(myItem.getContents());

        // 위젯에 대한 이벤트리스너
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, myItem.getName(), Toast.LENGTH_SHORT).show();
                Intent myintent = new Intent(c, SecondActivity.class);
                myintent.putExtra("key", tv_name.getText().toString());
                ((Activity) c).startActivityForResult(myintent, 1);
            }
        });

        return convertView;
    }

    // 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성
    public void addItem(Drawable img, String name, String contents) {

        MyItem mItem = new MyItem(img, name, contents);

        // MyItem에 아이템을 setting
        mItem.setIcon(img);
        mItem.setName(name);
        mItem.setContents(contents);

        // mItems에 MyItem을 추가
        mItems.add(mItem);
    }
}