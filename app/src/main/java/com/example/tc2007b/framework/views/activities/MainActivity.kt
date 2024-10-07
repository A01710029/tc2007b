package com.example.tc2007b.framework.views.activities

import android.app.Activity
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
    private var _binding: MainActivityBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    private lateinit var viewModel: DragonBallViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : DragonBallAdapter = DragonBallAdapter()
    private lateinit var items:List<Character>

    override fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        _binding = MainActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        items = mutableListOf()

        initializeComponents(root)
        initializeObservers()
        viewModel.getAllCharacters()

        return root
    }

    private fun initializeComponents(root: View){
        recyclerView = root.findViewById(R.id.RVCharacters)
    }

    private fun initializeObservers() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) { character ->
            if (character != null) {
                setUpRecyclerView(character.results)
            }
        }
    }

    private fun setUpRecyclerView(dataForList:List<Character>){
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = gridLayoutManager
        adapter.DragonBallAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }
}