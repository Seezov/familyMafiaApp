package com.example.familymafiaapp.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.familymafiaapp.R
import com.example.familymafiaapp.entities.Game
import com.example.familymafiaapp.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshiAdapter = viewModel.moshi.adapter(Game::class.java)
        rvGames.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewModel.adapter
        }
        viewModel.game.observe(this){
            Log.d("TESTTESTTEST", moshiAdapter.toJson(it))
            viewModel.adapter.submitList(viewModel.adapter.currentList + it)
        }
        viewModel.getGames()
    }
}