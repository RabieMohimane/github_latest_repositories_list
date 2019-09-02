package com.rabie.githublatestrepositories.data.remote

import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface AppApi {

    @Headers("accept: application/json")
    @GET("repositories?sort=stars&order=desc")
    fun getRepositories(@Query("q") startDate: String, @Query("page") page: Int): Single<Response<RepositoriesWrapper>>


}