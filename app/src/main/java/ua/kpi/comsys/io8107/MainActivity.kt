package ua.kpi.comsys.io8107

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment: FirstFragment = FirstFragment()
        val secondFragment : SecondFragment = SecondFragment()

        setTabFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> setTabFragment(firstFragment)
                R.id.second -> setTabFragment(secondFragment)
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