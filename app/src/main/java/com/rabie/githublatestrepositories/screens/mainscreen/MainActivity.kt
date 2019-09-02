package com.rabie.githublatestrepositories.screens.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rabie.githublatestrepositories.R
import com.rabie.githublatestrepositories.viewmodels.AppViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
lateinit var mViewModel: AppViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel= ViewModelProviders.of(this).get(AppViewModel::class.java)
        mViewModel.getGitHubLatestRepositories("created:>2019-08-01",0).observe(this, Observer {
            if(it.isSuccessful){
                Timber.e(it.body().toString())
            }else{
                Timber.e(it.errorBody().toString())
            }
        })
    }
}
