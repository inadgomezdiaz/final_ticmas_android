package com.curso.android.app.trabajo_final_ticmas.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.trabajo_final_ticmas.model.ComparationResult

class MainViewModel : ViewModel() {

    private val _comparationResult = MutableLiveData<ComparationResult>()

    val comparationResult: LiveData<ComparationResult> = _comparationResult

    fun compareStrings(text1: String , text2: String) {
        val sonIguales = text1 == text2
        _comparationResult.value = ComparationResult(sonIguales)
    }
}