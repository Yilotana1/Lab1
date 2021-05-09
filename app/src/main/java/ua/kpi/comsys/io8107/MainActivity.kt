package ua.kpi.comsys.io8107

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import ua.kpi.comsys.io8107.ListPage.DAO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();
        val firstFragment: FirstFragment = FirstFragment()
        val secondFragment: GraphicFrahment = GraphicFrahment()
        val thirdFragment: ListFragment = ListFragment()

        setTabFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setTabFragment(firstFragment)
                R.id.second -> setTabFragment(secondFragment)
                R.id.third -> setTabFragment(thirdFragment)
            }
            true
        }


    }

    private fun setTabFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Fragment, fragment)
            commit()
        }
    }

}