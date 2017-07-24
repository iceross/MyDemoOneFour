package com.benhuan.mycustomcontrol;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.View;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-19
 * Time: 11:50
 * Desc:
 */

public class CCView2 extends View {

    Paint paint;

    public CCView2(Context context) {
        this(context, null);
    }

    public CCView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CCView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawShaderColor(canvas);
    }

    void initPaint() {

        paint = new Paint();

        LruCache<String,Bitmap> mBitmapLruCache = new LruCache<>(1);


    }

    void drawShaderColor(Canvas canvas) {

        Shader shader = new LinearGradient(
                100,100,500,500, Color.parseColor("#e91e63"),
                Color.parseColor("#ffffff"), Shader.TileMode.CLAMP
        );

        paint.setShader(shader);

        canvas.drawCircle(300,300,200,paint);
    }
}
