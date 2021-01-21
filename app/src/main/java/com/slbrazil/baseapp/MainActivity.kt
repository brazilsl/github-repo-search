package com.slbrazil.baseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.slbrazil.baseapp.databinding.MainActivityBinding

import com.slbrazil.baseapp.ui.main.MainFragment
import com.slbrazil.baseapp.ui.main.MainViewModel
import com.slbrazil.baseapp.ui.main.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private val viewModel: MainViewModel by viewModels() { viewModelFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
        
        binding.searchField.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                viewModel.setSearchInput(binding.searchField.text.toString())
                true
            }
            else -> false
        } }

    }
}