package com.slbrazil.baseapp.ui.main

import com.slbrazil.gitrepo.GitHubRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.slbrazil.gitrepo.GitHubRepositoryImpl

class MainViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    //todo need to inject
   val repo: GitHubRepository = GitHubRepositoryImpl()
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(repo) as T
}