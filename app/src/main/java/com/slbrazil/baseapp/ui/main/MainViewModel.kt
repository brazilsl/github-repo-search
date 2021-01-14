package com.slbrazil.baseapp.ui.main

import GitHubRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.slbrazil.github_common_model.GithubRepo

class MainViewModel constructor(repository: GitHubRepository) : ViewModel() {

    private val repo = repository
    private val TAG : String = MainViewModel::class.java.simpleName

    private val searchInput : MutableLiveData<String> = MutableLiveData<String>()
    private lateinit var  gitRepos : LiveData<List<GithubRepo>>

    fun setSearchInput(text: String){

        searchInput.value = text;
        Log.d(TAG, "search input: ${searchInput.value}" )
        gitRepos = repo.getRepos(text)
    }

    fun getSearchInput() :LiveData<String>{

        return searchInput
    }

    fun getRepos() : LiveData<List<GithubRepo>> {
        return gitRepos;
    }
}