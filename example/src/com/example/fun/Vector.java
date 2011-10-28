package com.example.fun;

import android.util.FloatMath;

public class Vector {
    public float x, y;

    public Vector() {
        this(0, 0);
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector v) {
        this(v.x, v.y);
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void add(Vector v) {
        add(v.x, v.y);
    }

    public void sub(Vector v) {
        sub(v.x, v.y);
    }

    public void sub(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public void mult(float x, float y) {
        this.x *= x;
        this.y *= y;
    }

    public void mult(Vector v) {
        mult(v.x, v.y);
    }

    public void mult(float c) {
        mult(c, c);
    }

    public float mag() {
        if (x == 0 && y == 0) {
            return 0;
        } else {
            return FloatMath.sqrt(x * x + y * y);
        }
    }

    public float magSquared() {
        return x * x + y * y;
    }

    public void set(Vector v) {
        x = v.x;
        y = v.y;
    }

    public static void sub(Vector a, Vector b, Vector result) {
        result.x = (a.x - b.x);
        result.y = (a.y - b.y);
    }

    public static void mult(Vector v, float c, Vector result) {
        result.x = (v.x * c);
        result.y = (v.y * c);
    }

    public static float mag(Vector a, Vector b) {
        float x = (a.x - b.x);
        float y = (a.y - b.y);
        if (x == 0 && y == 0) {
            return 0;
        } else {
            return FloatMath.sqrt(x * x + y * y);
        }
    }
}
