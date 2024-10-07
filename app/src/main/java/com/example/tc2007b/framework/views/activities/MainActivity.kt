package com.example.tc2007b.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007b.R
import com.example.tc2007b.databinding.MainActivityBinding
import com.example.tc2007b.framework.adapters.DragonBallAdapter
import com.example.tc2007b.framework.viewmodel.DragonBallViewModel
import com.example.tc2007b.data.network.model.CharacterBase
import com.example.tc2007b.framework.views.fragments.CharacterFragment

class MainActivity: AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceBundle: Bundle?){
        super.onCreate(savedInstanceBundle)

        initializeBinding()
        exchangeCurrentFragment(CharacterFragment())
    }

    private fun initializeBinding() {
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun exchangeCurrentFragment(newFragment: Fragment) {
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, currentFragment)
            .commit()
    }
}