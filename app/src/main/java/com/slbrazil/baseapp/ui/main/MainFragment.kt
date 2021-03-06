package com.slbrazil.baseapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.slbrazil.baseapp.databinding.MainFragmentBinding
import com.slbrazil.github_common_model.GitRepositories
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }
    @Inject lateinit var viewModelFactory: MainViewModelFactory
    @Inject lateinit var adapter: GithubRepoAdapter

    private lateinit var binding: MainFragmentBinding
    private val TAG : String = MainFragment::class.java.simpleName
    private val viewModel: MainViewModel by activityViewModels() { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding =  MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.list.adapter = adapter

        val repoObserver = Observer<GitRepositories> { repos ->
            // update the recyclerview
            Log.d(TAG, "update recyclerview with: " + repos.items.size)
           adapter.setItems(repos.items)
        }

        val searchObserver = Observer<String> { keyword ->
            // observe the repo
            Log.d(TAG, "should search for: $keyword")
            viewModel.getRepos().observe(viewLifecycleOwner, repoObserver)
        }
        Log.d(TAG, "observing search")
        viewModel.getSearchInput().observe(viewLifecycleOwner, searchObserver )

    }

}