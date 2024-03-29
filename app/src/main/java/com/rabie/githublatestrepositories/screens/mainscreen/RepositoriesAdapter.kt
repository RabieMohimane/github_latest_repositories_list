package com.rabie.githublatestrepositories.screens.mainscreen

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.rabie.githublatestrepositories.R
import com.rabie.githublatestrepositories.data.models.Item
import com.rabie.githublatestrepositories.screens.repodetails.DetailsActivity


class RepositoriesAdapter(var items: List<Item>) : RecyclerView.Adapter<RepositoriesAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repo_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RepositoriesAdapter.MyViewHolder, position: Int) {
        var item = items.get(position)
        holder.tvRepoName.text = item.full_name
        holder.btnRepo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Toast.makeText(
                    holder.itemView.context,
                    "repos clicked ${items.get(holder.adapterPosition).full_name}",
                    Toast.LENGTH_SHORT
                ).show()
                val intent=Intent(holder.itemView.context,DetailsActivity::class.java)
                intent.putExtra("repo",items.get(holder.adapterPosition))
                holder.itemView.context.startActivity(intent)
            }

        })
    }

    fun addItems(newItms: List<Item>) {
        (items as ArrayList<Item>).addAll(newItms)
        notifyDataSetChanged()

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvRepoName: TextView
        var btnRepo: ConstraintLayout

        init {
            tvRepoName = itemView.findViewById(com.rabie.githublatestrepositories.R.id.tvRepository)
            btnRepo = itemView.findViewById(com.rabie.githublatestrepositories.R.id.btnRepo)
        }

    }
}