package com.example.tc2007b.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007b.data.network.model.CharacterBase
import com.example.tc2007b.databinding.FragmentCharacterBinding
import com.example.tc2007b.databinding.MainActivityBinding
import com.example.tc2007b.framework.adapters.DragonBallAdapter
import com.example.tc2007b.framework.viewmodel.DragonBallViewModel

class CharacterFragment: Fragment() {
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DragonBallViewModel

    private lateinit var adapter: DragonBallAdapter

    private lateinit var recyclerView: RecyclerView
    private var items:List<CharacterBase> = emptyList()
    private var filteredItems:List<CharacterBase> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

            _binding = FragmentCharacterBinding.inflate(layoutInflater)
            val root: View = binding.root

            viewModel = ViewModelProvider(this).get(DragonBallViewModel::class.java)

            initializeComponents()
            initializeObservers()

            viewModel.getAllCharacters()

        return root
    }

    private fun setUpSpinnerAff(){
        val affiliations = listOf("All", "Z Fighter", "Army of Frieza", "Freelancer", "Other", "Villain", "Assistant of Beerus", "Pride Troopers", "Assistant of Vermoud")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, affiliations)
        binding.spinnerAff.adapter = adapter
        binding.spinnerAff.setSelection(0)

        binding.spinnerAff.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id:Long){
                filterList(affiliations[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(){
        recyclerView = binding.RVCharacters
        adapter = DragonBallAdapter(emptyList(), requireContext())
        recyclerView.adapter = adapter
        val columnas = 2
        recyclerView.layoutManager = GridLayoutManager(requireContext(), columnas)
        setUpSpinnerAff()
    }

    private fun initializeObservers(){
        viewModel.characterListLiveData.observe(viewLifecycleOwner) { ApiResponse ->
            if (ApiResponse != null) {
                items = ApiResponse.items
            }
            setUpRecyclerView(items)
        }
    }

    private fun setUpRecyclerView(dataForList: List<CharacterBase>) {
        adapter.updateItems(dataForList)
    }

    private fun filterList(selectedAff: String) {
        filteredItems = if (selectedAff == "All") {
            items
        } else {
            items.filter { it.affiliation == selectedAff }
        }
        setUpRecyclerView(filteredItems)
    }
}