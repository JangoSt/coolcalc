package com.damaja.cocktailmixxer.AddCocktail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

import com.damaja.cocktailmixxer.MainContent.PanelSlideUp;
import com.damaja.cocktailmixxer.R;

/**
 * Created by Matze on 06.04.2015.
 */
public class cocktailbar extends SeekBar {
    Paint mRectPaint, mBitmapPaint;
    public cocktailbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRectPaint = new Paint();
        mBitmapPaint = new Paint();
        mBitmapPaint.setColor(getResources().getColor(android.R.color.white));
        mRectPaint.setColor(getResources().getColor(R.color.appColor));
        setProgressDrawable(new ColorDrawable(android.R.color.transparent));
        setThumb(getResources().getDrawable(android.R.color.transparent));
//        setThumb(getResources().getColor(android.R.color.transparent));
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(-90);
        canvas.translate(-getHeight(), 0);
        Bitmap bar = BitmapFactory.decodeResource(getResources(), R.drawable.cocktailbar);

        bar = Bitmap.createScaledBitmap(bar, getWidth(),getHeight(),false);
        int yValue = (int)((double)(getHeight()-getThumbOffset())/getMax()*getProgress());

        canvas.drawRect(0,0,yValue,getWidth(),mRectPaint);
        canvas.rotate(90);
        canvas.drawBitmap(bar,0,-getHeight(),mBitmapPaint);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                int i=0;
                i=getMax() - (int) (getMax() * event.getY() / getHeight());
                setProgress(i);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }


}