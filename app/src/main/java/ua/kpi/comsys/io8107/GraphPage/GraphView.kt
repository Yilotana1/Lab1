package ua.kpi.comsys.io8107.GraphPage

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View
import kotlin.math.cos

class GraphView(context: Context) : View(context) {


    private val xMin = -Math.PI.toFloat()
    private val xMax = Math.PI.toFloat()
    private val delta = 0.01f


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawGraph(canvas, xMin, xMax, delta)
    }


    fun cosX(xMin: Float, xMax: Float, delta: Float): Array<FloatArray> {
        val xPoints: MutableList<Float> = ArrayList()
        val yPoints: MutableList<Float> = ArrayList()
        var x: Float = xMin
        var i = 1

        while (x <= xMax) {

            xPoints.add(x)
            yPoints.add(-cos(x))
            x += delta
            if (i % 2 != 0) {
                x += delta
            }
            i++
        }
        val res = arrayOf(xPoints.toFloatArray(), yPoints.toFloatArray())

        return res
    }

    fun drawGraph(canvas: Canvas, xMin: Float, xMax: Float, delta: Float) {
        val path = Path()
        val paint = Paint()
        paint.style = Paint.Style.STROKE
        paint.color = Color.GREEN
        paint.strokeWidth = 5f

        val xPoints: FloatArray
        val yPoints: FloatArray
        val arr: Array<FloatArray> = cosX(xMin, xMax, 0.01f)
        xPoints = arr[0]
        yPoints = arr[1]
        for (i in xPoints.indices) {
            xPoints[i] = 100 * xPoints[i]
            yPoints[i] = 100 * yPoints[i]
        }


        path.moveTo(xPoints[0] + width / 2, yPoints[0] + height / 2)

        for (i in 1 until xPoints.size) {
            path.lineTo(xPoints[i] + width / 2, yPoints[i] + height / 2)
        }

        canvas.drawPath(path, paint)
    }

}