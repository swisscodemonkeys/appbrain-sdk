package com.appbrain.example.logo

open class SpringObject(start: Vector) {
    val pos: Vector = Vector(start)
    private val vel: Vector = Vector(0f, 0f)
    val goal: Vector = Vector(start)

    private val d = Vector()

    open fun update() {
        Vector.sub(goal, pos, d)
        d.mult(SPRING_STRENGTH)
        vel.add(d)
        vel.mult(FRICTION)
        pos.add(vel)
    }

    companion object {
        const val SPRING_STRENGTH = 0.1f
        const val FRICTION = 0.8f
    }
}
