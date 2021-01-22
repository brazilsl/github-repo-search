package com.slbrazil.gitrepo

import android.util.Log
import com.slbrazil.github_common_model.GitRepositories
import com.slbrazil.github_repo_service.GithubService
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(githubService: GithubService) : GithubRepository {
    private val TAG : String = GitHubRepositoryImpl::class.java.simpleName
    private val service = githubService


    override suspend fun getRepos(keywords: String): GitRepositories {
        Log.d(TAG, "searching: $keywords")

     /*   val repo1 = GithubRepo()
        repo1.repoName = "test repo 1"
        repo1.ownerName = "shanitha 1"

        val repo2 = GithubRepo()
        repo2.repoName = "test repo 2"
        repo2.ownerName = "shanitha 2"

        val repo3 = GithubRepo()
        repo3.repoName = "test repo 3"
        repo3.ownerName = "shanitha 3"

        val repoList = arrayListOf(repo1, repo2, repo3)*/

        return service.search(keywords, 1, 10)

    }
}