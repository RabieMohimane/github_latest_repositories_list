package com.rabie.githublatestrepositories.data.remote


import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class AppService(var webservice: AppApi) : AppApi {
    override fun getRepositories(startDate: String, page: Int): Single<Response<RepositoriesWrapper>> {
        return webservice.getRepositories(startDate, page)
    }


}
