package com.example.logonrmlocal.notpadapplication.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notpadapplication.model.Nota
import com.example.logonrmlocal.notpadapplication.repository.NotaRepository

class MainViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun findAll() {
        isLoading.value = true
        notaRepository
                .findAll(onComplete = {
                    isLoading.value = false
                    notas.value = it
                }, onError = {
                    isLoading.value = false
                    notas.value = mutableListOf()
                })
    }
}