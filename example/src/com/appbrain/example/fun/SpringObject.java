package com.appbrain.example.fun;

public class SpringObject {
    public static final float springStrength = 0.1f;
    public static final float friction = 0.8f;
    public Vector pos, vel, goal;

    public SpringObject(Vector start) {
        this.pos = new Vector(start);
        this.vel = new Vector(0, 0);
        this.goal = new Vector(start);
    }

    private Vector d = new Vector();

    public void update() {
        Vector.sub(goal, pos, d);
        d.mult(springStrength);
        vel.add(d);
        vel.mult(friction);
        pos.add(vel);
    }
}
