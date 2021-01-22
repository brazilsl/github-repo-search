package com.slbrazil.baseapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.slbrazil.baseapp.databinding.RecyclerViewItemBinding
import com.slbrazil.github_common_model.Item
import javax.inject.Inject

//todo add paging
class GithubRepoAdapter @Inject constructor() : RecyclerView.Adapter<GithubRepoAdapter.ViewHolder>() {

    var repoList: List<Item> = arrayListOf()

    class ViewHolder(binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.gitRepoViewHolder) {

        val repoBinding = binding

        fun bind(repo: Item){

            repoBinding.gitHubRepo = repo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent,
           false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

       return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(repoList[position])
    }

    fun setItems(repos: List<Item>){
        repoList = repos
        notifyDataSetChanged()
    }
}