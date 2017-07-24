package com.benhuan.mycustomcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-17
 * Time: 16:44
 * Desc:
 */

public class CCView1 extends View {

    Paint paint1;

    public CCView1(Context context) {
        this(context, null);
    }

    public CCView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CCView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


    }

    void initPaint(){

        paint1 = new Paint();

        paint1.setStyle(Paint.Style.STROKE);

        paint1.setColor(Color.parseColor("#ff0000"));

        paint1.setStrokeWidth(15);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();

        paint1.setAntiAlias(true);

        //drawPoints(canvas);

        //drawOval(canvas);

        //drawLine(canvas);

        //drawArc(canvas);

        //drawPath(canvas);

        //drawBitmap(canvas);

        drawText(canvas);

    }

    void drawCircle(Canvas canvas) {

        canvas.drawCircle(300,300,150,paint1);

        //canvas.drawColor(Color.parseColor("#22ff0066"));


        canvas.drawRGB(100,100,100);

        canvas.drawCircle(600,300,150,paint1);

        paint1.setColor(Color.parseColor("#667788"));

        canvas.drawRoundRect(100,100,500,500,30,30,paint1);


        //canvas.drawColor(Color.parseColor("#88880000"));

    }

    void drawPoints(Canvas canvas) {
        //3代表从第三个坐标点开始
        //8代表从坐标点的个数
        float[] points = {0,0,50,50,50,100,100,50,100,100,150,50,150,100};
        canvas.drawPoints(points,3,10,paint1);
    }

    void drawOval(Canvas canvas) {

        canvas.drawOval(50,50,350,200,paint1);

        paint1.setStyle(Paint.Style.FILL);

        canvas.drawOval(400,50,700,200,paint1);

        RectF rectF = new RectF(20,20,800,300);

        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawOval(rectF,paint1);
    }

    void drawLine(Canvas canvas) {

        float[] points = {20,20,120,20,
                70,20,70,120,
                20,120,120,120,
                150,20,150,120,
                250,120,250,20,
                150,20,250,20,
                250,120,150,120};
        canvas.drawLines(points,paint1);
    }

    void drawArc(Canvas canvas) {

       // paint1.setStyle(Paint.Style.FILL);


        //canvas.drawArc(200,100,800,550,-110,100,true,paint1);
       // canvas.drawArc(200,100,800,500,20,140,false,paint1);

        paint1.setStyle(Paint.Style.STROKE);


        canvas.drawOval(400,50,700,200,paint1);


        canvas.drawArc(400,50,700,200,-90,60,true,paint1);
    }

    void drawPath(Canvas canvas) {

        Path path = new Path();

        paint1.setStyle(Paint.Style.STROKE);

        path.addArc(200,200,400,400,-225,225);
        path.lineTo(400,200);
        path.lineTo(600,400);
        path.arcTo(400,200,600,400,0,90,false);
        //path.lineTo(400,542);

        path.close();

        canvas.drawPath(path,paint1);

    }

    void drawBitmap(Canvas canvas) {

        Bitmap  bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.mipmap.ic_launcher);

        canvas.drawBitmap(bitmap,300,150,paint1);

    }


    void drawText(Canvas canvas) {

        paint1.setStyle(Paint.Style.STROKE);

        paint1.setStrokeWidth(1);

        paint1.setTextSize(60);

        String text = "Hello coder";

        canvas.drawText(text,300,200,paint1);

    }
}
