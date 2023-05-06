package com.example.livescoreui.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoreui.R
import com.example.livescoreui.adapter.SportsAdapter
import com.example.livescoreui.data.SportsDash
import com.example.livescoreui.databinding.ActivityDashBoardBinding

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var recycler:RecyclerView
    private lateinit var sportsList:ArrayList<SportsDash>
    private lateinit var sportsAdapter: SportsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //set a binding view
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize a recyclerView
        recycler = binding.recyclerDash
        binding.recyclerDash.setHasFixedSize(true)
        binding.recyclerDash.layoutManager = GridLayoutManager(this,3)

        //set a date list in array
        sportsList = ArrayList()

        sportsList.add(SportsDash(R.drawable.ic_score, getString(R.string.football)))
        sportsList.add(SportsDash(R.drawable.ic_basketball, getString(R.string.basketball)))
        sportsList.add(SportsDash(R.drawable.rugby_ball, getString(R.string.rugbyball)))
        sportsList.add(SportsDash(R.drawable.ic_baseball, getString(R.string.baseball)))
        sportsList.add(SportsDash(R.drawable.ic_tennis, getString(R.string.tennis)))
        sportsList.add(SportsDash(R.drawable.ic_volleyball, getString(R.string.volleyball)))

        sportsAdapter = SportsAdapter(sportsList)
        binding.recyclerDash.adapter = sportsAdapter

        binding.btnContinuDash.setOnClickListener{
            val intent = Intent(this@DashBoardActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}