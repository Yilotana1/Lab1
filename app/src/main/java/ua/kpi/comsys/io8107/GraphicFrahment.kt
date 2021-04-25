package ua.kpi.comsys.io8107

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ua.kpi.comsys.io8107.GraphPage.DiagramFragment
import ua.kpi.comsys.io8107.GraphPage.GraphFragment

class GraphicFrahment : Fragment() {


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















