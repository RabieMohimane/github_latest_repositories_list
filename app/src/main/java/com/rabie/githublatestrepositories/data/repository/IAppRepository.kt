package com.rabie.githublatestrepositories.data.repository

import androidx.lifecycle.LiveData

import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper

import retrofit2.Response

interface IAppRepository {

    fun getGithubRepositoriesFromRemote(startDate:String,page:Int): LiveData<Response<RepositoriesWrapper>>
   }