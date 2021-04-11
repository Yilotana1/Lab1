package ua.kpi.comsys.io8107

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View

class DiagramView(context: Context) : View(context) {


    private val radius = 250f
    private val bold = 200f

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawDiagram(canvas, radius, bold)

    }

    fun drawDiagram(canvas: Canvas, radius: Float, bold: Float) {
        val paint1 = Paint()
        paint1.color = Color.rgb(0, 191, 255)
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = bold

        val paint2 = Paint()
        paint2.color = Color.rgb(160, 32, 240)
        paint2.style = Paint.Style.STROKE
        paint2.strokeWidth = bold

        val paint3 = Paint()
        paint3.color = Color.YELLOW
        paint3.style = Paint.Style.STROKE
        paint3.color = Color.YELLOW
        paint3.strokeWidth = bold


        val paint4 = Paint()
        paint4.color = Color.GRAY
        paint4.style = Paint.Style.STROKE
        paint4.strokeWidth = bold

        val rectF = RectF(
            width / 2 - radius, height / 2 - radius, width / 2 + radius,
            height / 2 + radius
        )

        canvas.drawArc(rectF, 0f, 162f, false, paint1)
        canvas.drawArc(rectF, 162f, 18f, false, paint2)
        canvas.drawArc(rectF, 180f, 90f, false, paint3)
        canvas.drawArc(rectF, 270f, 90f, false, paint4)

    }
}