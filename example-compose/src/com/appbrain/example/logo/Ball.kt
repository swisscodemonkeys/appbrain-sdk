package com.appbrain.example.logo

/**
 * A single animated square in the logo. Kept as a plain data holder + physics
 * step; drawing happens in the Compose [LogoView] canvas.
 */
class Ball(
    start: Vector,
    startPosZ: Float,
    radius: Float,
    val colorArgb: Int
) : SpringObject(start) {

    private var posZ: Float = startPosZ
    private var velZ: Float = 0f
    val startPos: Vector = Vector(start)
    private val startRadius: Float = radius

    var radius: Float = radius
        private set

    constructor(x: Float, y: Float, z: Float, radius: Float, colorArgb: Int) :
        this(Vector(x, y), z, radius, colorArgb)

    override fun update() {
        super.update()

        val dist = Vector.mag(startPos, pos)
        val goalZ = dist / 100.0f + 1.0f
        val dgZ = goalZ - posZ
        velZ += dgZ * SPRING_STRENGTH
        velZ *= FRICTION
        posZ += velZ

        radius = (startRadius * posZ).coerceAtLeast(1f)
    }
}
