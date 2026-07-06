package com.appbrain.example.logo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

/**
 * Rasterizes the word "AppBrain" into a grid of [Ball]s and runs the spring
 * physics that makes them react to touch.
 */
class BallGroup(val width: Int, val height: Int, private val step: Int) {

    val balls = mutableListOf<Ball>()

    private val d = Vector()

    init {
        createText("AppBrain")
    }

    private fun createText(text: String) {
        val w = width / step * step
        val h = height / step * step
        if (w == 0 || h == 0) {
            return
        }

        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.WHITE
        paint.textSize = (h * 0.5f)
        paint.isFakeBoldText = true
        paint.isAntiAlias = true
        paint.textAlign = Paint.Align.CENTER
        bitmap.eraseColor(Color.BLACK)
        canvas.drawText(text, (w / 2).toFloat(), (h * 0.6f), paint)

        val pix = IntArray(w * h)
        bitmap.getPixels(pix, 0, w, 0, 0, w, h)

        val s = 1.2f
        val hsv = FloatArray(3)

        val midx = w / 2
        val midy = h / 2

        for (y in 0 until h step step) {
            for (x in 0 until w step step) {
                val offset = x + y * w
                var sum = 0L
                for (dy in 0 until step) {
                    for (dx in 0 until step) {
                        sum += (pix[offset + dx + dy * w] and 0xff).toLong()
                    }
                }

                sum /= (step * step).toLong()
                val radius = (step * sum / 255).toInt()
                if (radius > 1) {
                    hsv[0] = 360f * x / width
                    hsv[1] = 1f
                    hsv[2] = 1f

                    balls.add(
                        Ball(
                            s * (x - midx) + midx,
                            s * (y - midy) + midy,
                            0f,
                            radius.toFloat(),
                            Color.HSVToColor(hsv)))
                }
            }
        }
    }

    fun update(mouseX: Float, mouseY: Float) {
        // Indexed loop (not a for-each) to avoid allocating an iterator every frame.
        for (i in 0 until balls.size) {
            val ball = balls[i]
            d.x = mouseX - ball.pos.x
            d.y = mouseY - ball.pos.y
            if (d.magSquared() < 100 * 100) {
                Vector.sub(ball.pos, d, ball.goal)
            } else {
                ball.goal.set(ball.startPos)
            }
            ball.update()
        }
    }
}
