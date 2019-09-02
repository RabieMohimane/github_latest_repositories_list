package com.rabie.githublatestrepositories.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper
import com.rabie.githublatestrepositories.data.repository.AppRepository
import retrofit2.Response
import javax.inject.Inject

class AppViewModel: ViewModel() {
    @Inject lateinit var mRepository:AppRepository
    init {
        DaggerAppViewModelomponent.create().inject(this)
    }
    fun getGitHubLatestRepositories(startDate:String,page:Int):LiveData<Response<RepositoriesWrapper>>{
return mRepository.getGithubRepositoriesFromRemote(startDate, page)
    }
}