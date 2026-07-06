package com.appbrain.example.logo

import kotlin.math.sqrt

class Vector(var x: Float, var y: Float) {

    constructor() : this(0f, 0f)

    constructor(v: Vector) : this(v.x, v.y)

    fun add(v: Vector) {
        x += v.x
        y += v.y
    }

    fun mult(c: Float) {
        x *= c
        y *= c
    }

    fun magSquared(): Float = x * x + y * y

    fun set(v: Vector) {
        x = v.x
        y = v.y
    }

    companion object {
        fun sub(a: Vector, b: Vector, result: Vector) {
            result.x = a.x - b.x
            result.y = a.y - b.y
        }

        fun mag(a: Vector, b: Vector): Float {
            val x = a.x - b.x
            val y = a.y - b.y
            return sqrt(x * x + y * y)
        }
    }
}
