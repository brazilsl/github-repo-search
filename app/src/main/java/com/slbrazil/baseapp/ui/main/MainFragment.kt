package com.slbrazil.baseapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.slbrazil.baseapp.R
import com.slbrazil.baseapp.databinding.MainFragmentBinding
import com.slbrazil.github_common_model.GithubRepo

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private val TAG : String = MainFragment::class.java.simpleName
    private val viewModel: MainViewModel by activityViewModels() { MainViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return  MainFragmentBinding.inflate(inflater, container, false).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       // viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        val repoObserver = Observer<List<GithubRepo>> { repos ->
            // update the recyclerview
            Log.d(TAG, "update recyclerview with: " + repos.joinToString(","))
        }
        viewModel.getRepos().observe(viewLifecycleOwner, repoObserver)
    }




}