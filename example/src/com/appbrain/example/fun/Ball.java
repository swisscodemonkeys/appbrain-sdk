package com.appbrain.example.fun;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Ball extends SpringObject {
    public int color;
    public float posZ, velZ, goalZ;
    public float radius;
    public Vector startPos;
    public float startPosZ;
    public float startRadius;

    public Ball(Vector start, float startPosZ, float radius, int color) {
        super(start);
        this.color = color;
        this.posZ = startPosZ;
        this.velZ = 0;
        this.goalZ = startPosZ;
        this.radius = radius;
        this.startPos = new Vector(start);
        this.startPosZ = startPosZ;
        this.startRadius = radius;
    }

    public Ball(float x, float y, float z, float radius, String color) {
        this(new Vector(x, y), z, radius, Color.parseColor(color));
    }

    public Ball(float x, float y, float z, float radius, int color) {
        this(new Vector(x, y), z, radius, color);
    }

    @Override
    public void update() {
        super.update();

        float dist = Vector.mag(startPos, pos);
        goalZ = dist / 100.0f + 1.0f;
        float dgZ = goalZ - posZ;
        float aZ = dgZ * springStrength;
        velZ += aZ;
        velZ *= friction;
        posZ += velZ;

        radius = startRadius * posZ;
        radius = radius < 1 ? 1 : radius;
    }

    private static Paint paint = new Paint();
    {
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
    }

    public void draw(Canvas canvas) {
        paint.setColor(color);
        // don't do circles, they are extremely slow on hardware accelerated devices
        //canvas.drawCircle(pos.x, pos.y, radius, paint);
        canvas.drawRect(pos.x - radius / 2, pos.y - radius / 2, pos.x + radius / 2, pos.y + radius
            / 2, paint);
    }
}