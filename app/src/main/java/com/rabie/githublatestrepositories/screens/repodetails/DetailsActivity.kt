package com.rabie.githublatestrepositories.screens.repodetails

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
//import com.bumptech.glide.Glide
import com.rabie.githublatestrepositories.R
import com.rabie.githublatestrepositories.data.models.Item
import kotlinx.android.synthetic.main.activity_details.*



class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title="Repository Details"
        val repo=intent.getParcelableExtra<Item>("repo")
        tvName.text=repo.name
        tvDescription.text=repo.description
        ratingBar.rating= repo.score.toFloat()
        tvOwnerName.text=repo.owner.login
        Glide.with(this).load(repo.owner.avatar_url).apply(
            RequestOptions()
            .placeholder(R.drawable.user)
        ).into(circleImageView)
    }
}
