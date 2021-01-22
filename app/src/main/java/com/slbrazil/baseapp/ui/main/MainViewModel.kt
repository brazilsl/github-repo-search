package com.slbrazil.baseapp.ui.main

import com.slbrazil.gitrepo.GithubRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.slbrazil.github_common_model.GitRepositories
import kotlinx.coroutines.Dispatchers

class MainViewModel constructor(repository: GithubRepository) : ViewModel() {

    private val repo = repository
    private val TAG : String = MainViewModel::class.java.simpleName

    private val searchInput : MutableLiveData<String> = MutableLiveData<String>()
    private var  gitRepos : MutableLiveData<GitRepositories> = MutableLiveData<GitRepositories>()

    fun setSearchInput(text: String)  {

        searchInput.value = text;
        Log.d(TAG, "search input: ${searchInput.value}" )

    }

    fun getSearchInput() : LiveData<String>{

        return searchInput
    }

    fun getRepos() : LiveData<GitRepositories> {
         return liveData<GitRepositories>(Dispatchers.IO) {
            Log.d(TAG, "getting repos for query: ${searchInput.value}" )
           emit(repo.getRepos(searchInput?.value ?: ""))
        }
    }
}