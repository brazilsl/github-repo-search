package com.slbrazil.baseapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.slbrazil.baseapp.databinding.RecyclerViewItemBinding
import com.slbrazil.github_common_model.GithubRepo

//todo add paging
class GitHubRepoAdapter : RecyclerView.Adapter<GitHubRepoAdapter.ViewHolder>() {

    var repoList: List<GithubRepo> = arrayListOf()

    class ViewHolder(binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.gitRepoViewHolder) {

        val repoBinding = binding

        fun bind(repo: GithubRepo){

            repoBinding.gitHubRepo = repo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

       return repoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(repoList[position])
    }

    fun setItems(repos: List<GithubRepo>){
        repoList = repos
        notifyDataSetChanged()
    }
}