package com.slbrazil.gitrepo

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.slbrazil.github_common_model.GitRepositories

interface GithubRepository {
 suspend fun getRepos(search: String) : GitRepositories
}