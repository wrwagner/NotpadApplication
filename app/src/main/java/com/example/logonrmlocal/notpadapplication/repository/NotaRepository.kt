package com.example.logonrmlocal.notpadapplication.repository

import com.example.logonrmlocal.notpadapplication.api.getNotaAPI
import com.example.logonrmlocal.notpadapplication.model.Nota
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotaRepository {

    fun findAll(
            onComplete: (List<Nota>?) -> Unit,
            onError: (Throwable?) -> Unit
    ) {


        getNotaAPI()
                .findAll()
                .enqueue(object : Callback<List<Nota>> {
                    override fun onFailure(call: Call<List<Nota>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Nota>>?, response: Response<List<Nota>>?) {
                        onComplete(response?.body())
                    }
                })
    }
}