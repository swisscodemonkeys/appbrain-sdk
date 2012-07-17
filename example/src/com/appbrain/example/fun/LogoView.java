package com.appbrain.example.fun;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class LogoView extends View {
    public LogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private BallGroup ballGroup;

    int touchX = -100, touchY = -100;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            touchX = -100;
            touchY = -100;
        } else {
            touchX = (int) event.getX();
            touchY = (int) event.getY();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        doUpdate(canvas);
        invalidate();
    }

    void doUpdate(Canvas canvas) {
        if (ballGroup == null || ballGroup.width != getWidth() || ballGroup.height != getHeight()) {
            ballGroup = new BallGroup(getWidth(), getHeight(),
                (int) (4.0 * getResources().getDisplayMetrics().density));
        }

        ballGroup.update(touchX, touchY);
        ballGroup.draw(canvas);
    }

}