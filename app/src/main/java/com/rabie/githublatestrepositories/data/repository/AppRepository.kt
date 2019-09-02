package com.rabie.githublatestrepositories.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rabie.githublatestrepositories.data.models.RepositoriesWrapper
import com.rabie.githublatestrepositories.data.remote.AppService
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.Response

class AppRepository(var appService: AppService)  :IAppRepository {
   init {
       DaggerAppRepositoryComponent.create().inject(this)
   }

    override fun getGithubRepositoriesFromRemote(
        startDate: String,
        page: Int
    ): LiveData<Response<RepositoriesWrapper>> {
        val data = MutableLiveData<Response<RepositoriesWrapper>>()
        appService.getRepositories(startDate, page)
            .subscribeOn(Schedulers.io())
            .subscribe({ success ->
                Log.e("success", success.body().toString())

                data.postValue(success)

            }, { error ->
                Log.e("error", error.toString())
                data.postValue(null)
            })
        return data
    }
}