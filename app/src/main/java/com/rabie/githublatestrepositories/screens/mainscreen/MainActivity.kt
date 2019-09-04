package com.rabie.githublatestrepositories.screens.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rabie.githublatestrepositories.R
import com.rabie.githublatestrepositories.viewmodels.AppViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var mViewModel: AppViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RepositoriesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)
        mViewModel.getGitHubLatestRepositories("created:>2019-08-01", 0).observe(this, Observer {
            if (it.isSuccessful) {
                Timber.e(it.body().toString())
                viewAdapter= RepositoriesAdapter(it.body()!!.items!!)
                viewManager = LinearLayoutManager(this@MainActivity)
                recyclerView=findViewById<RecyclerView>(R.id.recyclerView).apply {

                    setHasFixedSize(true)
                    layoutManager=viewManager
                    adapter=viewAdapter
                }

            } else {
                Timber.e(it.errorBody().toString())
            }
        })
    }
}
