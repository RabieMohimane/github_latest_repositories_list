package com.rabie.githublatestrepositories.screens.mainscreen

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
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
    private lateinit var progressBar: ProgressBar
    private lateinit var viewAdapter: RepositoriesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var page: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.rabie.githublatestrepositories.R.layout.activity_main)
        progressBar=findViewById(R.id.progressBar)
        mViewModel = ViewModelProviders.of(this).get(AppViewModel::class.java)
        mViewModel.getGitHubLatestRepositories("created:>2019-08-01", page).observe(this, Observer {
            if (it.isSuccessful) {
                progressBar.visibility = View.GONE

                Timber.e(it.body().toString())
                lastVisibleItem = it.body()!!.items.size - 1
                totalItemCount = it.body()!!.total_count
                viewAdapter = RepositoriesAdapter(it.body()!!.items!!)
                viewManager = LinearLayoutManager(this@MainActivity)
                recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
                    visibility = View.VISIBLE
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapter
                    addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            if (!recyclerView.canScrollVertically(1))
                                if ( totalItemCount > viewAdapter!!.itemCount) {
                                    progressBar.visibility = View.VISIBLE
                                    loadMore()
                                }

                        }
                    })
                }

            } else {
                Timber.e(it.errorBody().toString())
            }
        })
    }

    fun loadMore() {
        page++
        mViewModel.getGitHubLatestRepositories("created:>2019-08-01", page).observe(this, Observer {
            if (it.isSuccessful) {
                viewAdapter.addItems(it!!.body()!!.items)
                progressBar.visibility = View.GONE
            }
        })
    }
}
