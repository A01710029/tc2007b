package com.example.tc2007b.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.CharacterBase
import com.example.tc2007b.domain.DragonBallListRequirement
import com.example.tc2007b.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DragonBallViewModel: ViewModel() {
    val characterListLiveData = MutableLiveData<ApiResponse?>()
    private val dragonballListRequirement = DragonBallListRequirement()

    fun getAllCharacters(){
        viewModelScope.launch(Dispatchers.IO){
            val result: ApiResponse? = dragonballListRequirement(Constants.MAX_CHARACTER_NUM)
            CoroutineScope(Dispatchers.Main).launch {
                characterListLiveData.postValue(result)
            }
        }
    }
}