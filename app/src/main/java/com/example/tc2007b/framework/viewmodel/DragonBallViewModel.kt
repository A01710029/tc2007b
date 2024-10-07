package com.example.tc2007b.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tc2007b.data.DragonBallRepository
import com.example.tc2007b.data.network.model.Character
import com.example.tc2007b.domain.DragonBallListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DragonBallViewModel {
    val characterLiveData = MutableLiveData<Character?>()
    private val dragonballListRequirement = DragonBallListRequirement()

    fun getAllCharacters(){
        viewModelScope.launch(Dispatchers.IO){
            val result: Character? = dragonballListRequirement()
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                characterLiveData.postValue(result)
            }
        }
    }
}