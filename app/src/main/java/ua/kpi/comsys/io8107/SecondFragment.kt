package ua.kpi.comsys.io8107

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.CustomFloatAttributes
import androidx.core.view.get
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.cos

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.second_fragment, null)
        val graphBtn = view.findViewById<Button>(R.id.graph)
        val diagramBtn = view.findViewById<Button>(R.id.diagram)

        val graphFragment = GraphFragment()
        val diagramFragment = DiagramFragment()
        val fragmentManager = activity?.supportFragmentManager

        graphBtn.setOnClickListener {
            fragmentManager
                ?.beginTransaction()?.apply {
                    replace(R.id.picture, graphFragment)
                    commit()
                }
        }

        diagramBtn.setOnClickListener {
            fragmentManager
                ?.beginTransaction()?.apply {
                    replace(R.id.picture, diagramFragment)
                    commit()
                }
        }

        return view
    }
}















