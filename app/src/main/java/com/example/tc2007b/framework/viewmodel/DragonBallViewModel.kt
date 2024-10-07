package com.example.tc2007b.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tc2007b.data.network.model.Character
import com.example.tc2007b.data.network.model.CharacterObject
import com.example.tc2007b.domain.DragonBallListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DragonBallViewModel: ViewModel() {
    val characterListLiveData = MutableLiveData<List<Character>?>()
    private val dragonballListRequirement = DragonBallListRequirement()

    fun getAllCharacters(){
        viewModelScope.launch(Dispatchers.IO){
            val result: List<Character>? = dragonballListRequirement()
            Log.d("Salida", result?.size.toString())
            CoroutineScope(Dispatchers.Main).launch {
                characterListLiveData.postValue(result)
            }
        }
    }
}