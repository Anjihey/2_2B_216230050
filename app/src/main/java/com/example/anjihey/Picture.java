package com.example.anjihey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Picture extends View
{

    float ii = 0;
    public Picture(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint pnt = new Paint();
        pnt.setStrokeWidth(6f);

        pnt.setColor(Color.parseColor("#FFFF00"));
        pnt.setStyle(Paint.Style.STROKE);

        RectF rect = new RectF();
        rect.set(200, (100), 600, 600);
        canvas.drawArc(rect, 270, ii, false, pnt);

        pnt.setColor(Color.parseColor("#FF8000"));
        rect = new RectF();
        rect.set(100, (100), 700, 600);
        canvas.drawArc(rect, (270-ii), ii, false, pnt);

        pnt.setColor(Color.parseColor("#FF0000"));
        rect = new RectF();
        rect.set(0, (100), 800, 600);
        canvas.drawArc(rect, (270-ii), ii, false, pnt);

        pnt.setColor(Color.parseColor("#00FF00"));
        rect = new RectF();
        rect.set(300, (100), 500, 600);
        canvas.drawArc(rect, (270-ii), ii, false, pnt);
    }

}
