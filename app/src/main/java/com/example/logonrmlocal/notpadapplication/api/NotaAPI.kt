package com.example.logonrmlocal.notpadapplication.api


import com.example.logonrmlocal.notpadapplication.model.Nota
import retrofit2.Call
import retrofit2.http.*

interface NotaAPI {

    @GET("/nota")
    fun findAll(): Call<List<Nota>>

    @GET("/nota/titulo/{titulo}")
    fun findByTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/nota")
    fun save(@Body nota: Nota): Call<Nota>

    @DELETE("/nota/{id}")
    fun delete(@Path("id") id: String): Call<Void>
}