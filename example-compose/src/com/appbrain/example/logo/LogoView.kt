package com.appbrain.example.logo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize

/**
 * The interactive "AppBrain" logo: a grid of springy squares that scatter away
 * from your finger. A Compose-canvas port of the original custom [android.view.View].
 */
@Composable
fun LogoView(modifier: Modifier = Modifier) {
    val density = LocalDensity.current.density
    var touch by remember { mutableStateOf(Offset(-100f, -100f)) }
    var sizePx by remember { mutableStateOf(IntSize.Zero) }

    // Drives the animation: bumped once per frame to trigger a redraw.
    var frame by remember { mutableLongStateOf(0L) }
    LaunchedEffect(Unit) {
        while (true) {
            withFrameNanos { frame = it }
        }
    }

    val ballGroup = remember(sizePx) {
        if (sizePx.width > 0 && sizePx.height > 0) {
            BallGroup(sizePx.width, sizePx.height, (4f * density).toInt().coerceAtLeast(1))
        } else {
            null
        }
    }

    Canvas(
        modifier = modifier
            .onSizeChanged { sizePx = it }
            .pointerInput(Unit) {
                awaitEachGesture {
                    while (true) {
                        val event = awaitPointerEvent()
                        val change = event.changes.firstOrNull()
                        if (change == null || event.changes.none { it.pressed }) {
                            touch = Offset(-100f, -100f)
                            break
                        }
                        touch = change.position
                    }
                }
            }
    ) {
        // Read `frame` so the canvas repaints every animation tick.
        @Suppress("UNUSED_EXPRESSION")
        frame

        val group = ballGroup ?: return@Canvas
        group.update(touch.x, touch.y)
        // Indexed loop (not a for-each) to avoid allocating an iterator every frame.
        val balls = group.balls
        for (i in 0 until balls.size) {
            val ball = balls[i]
            val r = ball.radius
            val half = r / 2
            drawRect(
                color = Color(ball.colorArgb),
                topLeft = Offset(ball.pos.x - half, ball.pos.y - half),
                size = Size(r, r))
        }
    }
}
