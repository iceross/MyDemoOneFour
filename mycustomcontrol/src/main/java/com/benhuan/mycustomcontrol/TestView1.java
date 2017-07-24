package com.benhuan.mycustomcontrol;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-19
 * Time: 11:15
 * Desc:
 */

public class TestView1 extends View {

    Paint paint;

    public TestView1(Context context) {
        this(context, null);
    }

    public TestView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        initPaint();

        setBackgroundResource(R.color.black);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(1000,1000);
    }

    void initPaint() {

        paint = new Paint();

        paint.setColor(Color.parseColor("#FFFFFFFF"));

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        drawH(canvas);

        drawBing(canvas);
    }


    void drawH(Canvas canvas) {

        paint.setStrokeWidth(100);

        canvas.drawLine(300,200,300,800,paint);
        canvas.drawLine(700,200,700,800,paint);
        canvas.drawLine(300,450,700,450,paint);

    }

    void drawBing(Canvas canvas) {

        RectF rectF = new RectF(500,500,900,900);

        paint.setStrokeWidth(1);

        paint.setColor(Color.RED);
        canvas.drawArc(rectF,-180,120,true,paint);

        canvas.translate(20,20);

        paint.setColor(Color.parseColor("#ff9800"));
        canvas.drawArc(rectF,-60,45,true,paint);

        paint.setColor(Color.parseColor("#6c3365"));
        canvas.drawArc(rectF,-10,5,true,paint);

        paint.setColor(Color.parseColor("#b9b973"));
        canvas.drawArc(rectF,0,5,true,paint);

        paint.setColor(Color.parseColor("#009688"));
        canvas.drawArc(rectF,10,45,true,paint);


        paint.setColor(Color.parseColor("#2894ff"));
        canvas.drawArc(rectF,60,120,true,paint);

    }

}
