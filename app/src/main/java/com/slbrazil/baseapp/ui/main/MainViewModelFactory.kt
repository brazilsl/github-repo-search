package com.slbrazil.baseapp.ui.main

import com.slbrazil.gitrepo.GithubRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val githubRepository: GithubRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(githubRepository) as T
}