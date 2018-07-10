package com.example.oprisnik.visibilityplayground

import android.graphics.*
import android.graphics.drawable.Drawable

class DebugDrawable : Drawable() {

    val paint = Paint().apply {
        color = 0xff0000000.toInt()
        textSize = 20f
    }

    var drawCount = 0

    override fun draw(canvas: Canvas?) {
        drawCount++
        canvas?.apply {
            drawColor(if (isVisible) 0x3300ff00 else 0x33ff0000)
            drawText("visible=$isVisible, drawn=$drawCount", bounds.left + 10f, bounds.centerY().toFloat(), paint)
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getOpacity(): Int = PixelFormat.OPAQUE

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun onBoundsChange(bounds: Rect?) {
        super.onBoundsChange(bounds)
        if (bounds != null) {
            paint.textSize = bounds.height() / 15f
        }
    }
}