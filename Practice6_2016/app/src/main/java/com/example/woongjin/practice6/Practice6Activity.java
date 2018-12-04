package com.example.woongjin.practice6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {
    int mX = 100, mY = 200;
    int mColor = Color.BLUE;

    public MyView(Context context){
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX = (int)event.getX();
        mY = (int)event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(50);
        canvas.drawText("터치한 곳에 사각형그리기 & 메뉴로 내부색 변경", 50, 100, paint);

        paint.setColor(mColor);
        canvas.drawRect(mX, mY, mX + 50, mY + 50, paint);

        super.onDraw(canvas);
    }
}

public class Practice6Activity extends AppCompatActivity {
    MyView moW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moW = new MyView(this);
        setContentView(moW);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                moW.mColor = Color.RED;
                return true;
            case R.id.green:
                moW.mColor = Color.GREEN;
                return true;
            case R.id.blue:
                moW.mColor = Color.BLUE;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
