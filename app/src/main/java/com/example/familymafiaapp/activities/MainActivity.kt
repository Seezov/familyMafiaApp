package com.example.familymafiaapp.activities

import android.os.Bundle
import com.example.familymafiaapp.R
import com.example.familymafiaapp.viewmodels.MainViewModel

class MainActivity : BaseMvvmActivity() {

    override val viewModel: MainViewModel by viewModelDelegate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getPlayers()
    }
}