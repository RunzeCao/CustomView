package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by CRZ on 2017/5/3 14:55 14:56.
 * CanvasPractice
 */

public class CanvasPractice extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private RectF rect;
    private LinearGradient linearGradient;

    public CanvasPractice(Context context) {
        super(context);
        init();
    }


    public CanvasPractice(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasPractice(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //参数一为渐变起初点坐标x位置，参数二为y轴位置，参数三和四分辨对应渐变终点，最后参数为平铺方式，这里设置为镜像
        linearGradient = new LinearGradient(0, 100, 100, 0, 0xFF47c1f9, 0xFF8169ff, Shader.TileMode.REPEAT);
        mPaint.setShader(linearGradient);
      /*  mPaint.setStrokeWidth(10f);
        rect = new RectF(0, -400, 400, 0);*/
    }

    //确定view的大小
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.d(TAG, "mWidth: " + mWidth + "mHeight: " + mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2, mHeight/2);
        canvas.drawCircle(0, 0, mWidth/2, mPaint);

        /*   paint.setColor(Color.BLUE);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,paint);

        paint.setColor(Color.GREEN);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,paint);
        invalidate();*/
        // 将坐标系原点移动到画布正中心
       /* canvas.translate(mWidth / 2, mHeight / 2);

        for (int i = 0; i <= 20; i++) {
            canvas.scale(0.9f, 0.9f);
            canvas.drawRect(rect, mPaint);
        }*/
    /*    canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)

        Path path = new Path();                     // 创建Path

        path.lineTo(200, 200);                      // lineTo
        path.lineTo(200,0);

        canvas.drawPath(path, mPaint);              // 绘制Path*/

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
