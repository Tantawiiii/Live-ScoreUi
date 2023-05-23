package com.example.livescoreui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.livescoreui.R
import com.example.livescoreui.databinding.ActivityHomeBinding
import com.example.livescoreui.fragments.DiscoveryFragment
import com.example.livescoreui.fragments.HomeFragment
import com.example.livescoreui.fragments.ProfileFragment
import com.example.livescoreui.fragments.StandingFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var bottomNavigation: MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigation = binding.bottomNavigation

        //Add fun od Bottom Navigation
       selectNevMeowBottomMenu()


    }

    private fun selectNevMeowBottomMenu(){
        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(1)

        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_discovery))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_statistics))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_profile))

        bottomNavigation.setOnClickMenuListener {

            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                2 -> {
                    replaceFragment(DiscoveryFragment.newInstance())
                }
                3 -> {
                    replaceFragment(StandingFragment.newInstance())
                }
                4 -> {
                    replaceFragment(ProfileFragment.newInstance())
                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
            }
            }
        }

    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()

    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()

    }


}