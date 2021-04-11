package ua.kpi.comsys.io8107

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide();
        val firstFragment: FirstFragment = FirstFragment()
        val secondFragment: SecondFragment = SecondFragment()

        setTabFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setTabFragment(firstFragment)
                R.id.second -> setTabFragment(secondFragment)
            }
            true
        }


//        val graphBtn = findViewById<Button>(R.id.graph)
//        Log.d("TAG", "graphBTN = " + graphBtn)
//        val diagramBtn = findViewById<Button>(R.id.diagram)
//        val graphFragment = GraphFragment()
//        val diagramFragment = DiagramFragment()
//
//        graphBtn.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction().apply {
//                    replace(R.id.picture, graphFragment)
//                    commit()
//                }
//        }
//
//        diagramBtn.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction().apply {
//                    replace(R.id.picture, diagramFragment)
//                    commit()
//                }
//        }

    }

    private fun setTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Fragment, fragment)
            commit()
        }
    }

}