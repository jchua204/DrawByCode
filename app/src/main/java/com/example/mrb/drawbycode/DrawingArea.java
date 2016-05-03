package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{

    Paint pntTextPaint;     // Painting object to handle the paint jobs for graphics
    Paint pntGraphicsPaint; // Painting object to handle the paint jobs for text
    Paint pntBlackGraphicsPaint;

    boolean blnShowText;
    int intTextPosition;

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntGraphicsPaint.setColor(Color.GREEN);
        pntGraphicsPaint.setStrokeWidth(50);
        pntBlackGraphicsPaint.setColor(Color.BLACK);
        pntBlackGraphicsPaint.setStrokeWidth(50);
        pntTextPaint.setColor(Color.RED);
        pntTextPaint.setStrokeWidth(10);



    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.

        super.onDraw(canvas);
        /*

        //body, face and chin
            canvas.drawRect((float) 250.0, (float) 800.0, (float) 350.0, (float) 100.0, pntBlackGraphicsPaint);
            canvas.drawCircle((float) 300.0, (float) 200.0, (float) 189.0, pntGraphicsPaint);
            canvas.drawRect((float) 400.0, (float) 400.0, (float) 200.0, (float) 160.0, pntGraphicsPaint);
        //names
            canvas.drawText("bobby", (float) 400.0, (float) 300.0, pntTextPaint);
        // face
            canvas.drawCircle((float) 200.0, (float) 150.0, (float) 10.0, pntBlackGraphicsPaint);
            canvas.drawCircle((float) 400.0, (float) 150.0, (float) 10.0, pntBlackGraphicsPaint);
            canvas.drawCircle((float) 300.0, (float) 230, (float) 50, pntBlackGraphicsPaint);
        //legs
            canvas.drawLine((float) 300, (float) 700, (float) 200, (float) 1000, pntBlackGraphicsPaint);
            canvas.drawLine((float)300,(float)700,(float)400,(float)1000,pntBlackGraphicsPaint);
        //arms, point, and text
            canvas.drawLine((float)300,(float)550,(float)50,(float)300,pntBlackGraphicsPaint);
            canvas.drawLine((float)300,(float)550,(float)550,(float)300,pntBlackGraphicsPaint);
            canvas.drawPoint((float) 300, (float)25, pntTextPaint);
            canvas.drawText("OHHHHHNOEEEESsSsSS", (float) 300, (float) 500, pntGraphicsPaint);



        float x;
        float y;
        for (int i = 0;i<canvas.getWidth() ;i++) {
                canvas.drawPoint(i*100,0,pntBlackGraphicsPaint);



        for (int i = 0; i < canvas.getHeight(); i++)
            canvas.drawLine((float)0,(float)i*140,(float)650,(float)i*140, pntTextPaint);
        for (int i = 0; i < canvas.getWidth(); i++)
            canvas.drawLine((float)i*140,(float)0,(float)i*140,(float)1100, pntTextPaint);

        */
        for (int w = 0; w < 15;w++) {
            int k = w%2;
            if (k == 0){
                for (int i = 0; i < 15; i++) {

                    canvas.drawPoint(25 + w * 50, 25 + i * 100, pntBlackGraphicsPaint);
                }
            }else {
                for (int i = 0; i < 15; i++) {

                    canvas.drawPoint(25 + w * 50, 75 + i * 100, pntBlackGraphicsPaint);
                }
            }
        }



    }



}
