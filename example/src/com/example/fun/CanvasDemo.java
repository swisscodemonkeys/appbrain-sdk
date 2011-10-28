package com.example.fun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

public class CanvasDemo extends View {

    public CanvasDemo(Context context) {
        super(context);
        init();
    }

    Canvas canvas;
    Canvas backBuffer;
    BallGroup ballGroup;

    // mouse positions relative to canvas
    int mouseX = -100, mouseY = -100;

    // timer refresh rate, in milliseconds
    static final int refreshRate = 25;

    final int redrawColor = Color.argb(0xaa, 0xff, 0xff, 0xff);

    private void init() {

        // init the objects
        // logoGroup = new LogoGroup(width, height, 18, 165);
        ballGroup = new BallGroup(300, 300);
        // lens = new Lens(35, 15, width, height, new Vector(320, 150), new
        // Vector(1, 1));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            mouseX = -100;
            mouseY = -100;
        } else {
            mouseX = (int) event.getX();
            mouseY = (int) event.getY();
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
        // update the back canvas
        canvas.drawColor(redrawColor);

        ballGroup.update(mouseX, mouseY);
        ballGroup.draw(canvas);

    }

}