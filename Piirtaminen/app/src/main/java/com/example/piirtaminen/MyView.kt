package com.example.piirtaminen

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var paint = Paint()
    var x1 = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas?.drawOval(x1, 100f, x1+100f, 200f, paint)
    }

    fun setXY(x: Float, y: Float)
    {
        x1 = x
        invalidate()
    }

}