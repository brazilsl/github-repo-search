package com.slbrazil.gitrepo

import GitHubRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.slbrazil.github_common_model.GithubRepo

class GitHubRepositoryImpl() : GitHubRepository {
    override fun getRepos(search: String): LiveData<List<GithubRepo>> {
        val repo1 = GithubRepo()
        repo1.repoName = "test repo 1"
        repo1.ownerName = "shanitha test repo"
        val repo2 = GithubRepo()
        repo2.repoName = "test repo 2"
        repo2.ownerName = "shanitha"
        val repoList = arrayListOf(repo1, repo2)
        var repos: MutableLiveData<List<GithubRepo>> = MutableLiveData<List<GithubRepo>>()
        repos.value = repoList
        return repos

    }
}