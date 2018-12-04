package kr.eshopping.user.touchrandom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyView = new MyView(this);
        setContentView(mMyView);
    }
}

class MyView extends View {
    Paint mPaint;
    int mX= -50, mY= -50;
    Random mR;
    RectF mRect;

    public MyView(Context context){
        super(context);
        mPaint = new Paint();
        mR = new Random();
        mRect = new RectF(100, 100, 400, 400);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX = (int) event.getX();
        mY = (int) event.getY();
        if(mRect.contains(mX,mY)){
            invalidate();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = mR.nextInt(256);
        int g = mR.nextInt(256);
        int b = mR.nextInt(256);
        mPaint.setColor( Color.rgb(r,g,b) );
        canvas.drawRect( mRect, mPaint);
    }
}
