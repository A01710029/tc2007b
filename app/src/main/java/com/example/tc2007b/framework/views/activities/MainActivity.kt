package com.example.tc2007b.framework.views.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007b.R
import com.example.tc2007b.databinding.MainActivityBinding
import com.example.tc2007b.framework.adapters.DragonBallAdapter
import com.example.tc2007b.framework.viewmodel.DragonBallViewModel
import com.example.tc2007b.data.network.model.Character

class MainActivity: AppCompatActivity() {
    private var binding: MainActivityBinding? = null

    private lateinit var viewModel: DragonBallViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : DragonBallAdapter = DragonBallAdapter()
    private lateinit var items:List<Character>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        viewModel = ViewModelProvider(this).get(DragonBallViewModel::class.java)

        // Initialize your list
        items = mutableListOf()

        // Call any initialization methods
        initializeComponents()
        viewModel.getAllCharacters()
    }

    private fun initializeComponents(root: View){
        recyclerView = root.findViewById(R.id.RVCharacters)
    }

    private fun setUpRecyclerView(dataForList:List<Character>){
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(
            this,
            3,
            GridLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = gridLayoutManager
        adapter.DragonBallAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }
}