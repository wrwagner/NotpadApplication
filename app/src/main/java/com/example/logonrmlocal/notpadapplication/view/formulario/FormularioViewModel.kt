package com.example.logonrmlocal.notpadapplication.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notpadapplication.model.Nota
import com.example.logonrmlocal.notpadapplication.model.ResponseStatus
import com.example.logonrmlocal.notpadapplication.repository.NotaRepository

class FormularioViewModel: ViewModel() {

    val notaRepositoty = NotaRepository()

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    fun salvar(titulo: String, descricao: String) {
        val nota = Nota(null, titulo, descricao)
        notaRepositoty.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true,
                            "Dados gravados com sucesso")
                }, onError = {
                responseStatus.value = ResponseStatus(false,
                        it?.message!!)
        })
    }
}