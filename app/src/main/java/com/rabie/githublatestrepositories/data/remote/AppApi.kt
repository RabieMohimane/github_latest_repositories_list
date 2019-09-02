package com.rabie.githublatestrepositories.data.remote

import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface AppApi {

    @Headers("accept: application/json")
    @GET("{startDate}&sort=stars&order=desc&page={page}")
    fun getRepositories(@Path("startDate") startDate: String, @Path("startDate") page: Int): Single<Response<RepositoriesWrapper>>


}