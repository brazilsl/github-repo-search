package com.slbrazil.gitrepo

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.slbrazil.github_common_model.GithubRepo

interface GitHubRepository {
 fun getRepos(search: String) : List<GithubRepo>
}