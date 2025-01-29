package com.example.idealistachallengefranciscogaitan.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idealistachallengefranciscogaitan.databinding.ActivityMainBinding
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem
import com.example.idealistachallengefranciscogaitan.presentation.detail.PropertyDetailActivity
import com.example.idealistachallengefranciscogaitan.presentation.list.PropertyListAdapter
import com.example.idealistachallengefranciscogaitan.presentation.list.PropertyListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val propertyListViewModel: PropertyListViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private lateinit var propertyAdapter: PropertyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTheRecyclerView()
        collect()
        getFavoriteProperties()
    }

    private fun collect() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    propertyListViewModel._propertyListValue.collect { propertyListValue ->
                        val allProperties = propertyListValue
                        propertyListViewModel._favoriteListValue.value.forEach { favoriteProperty ->
                            allProperties.forEach { property ->
                                if (property.propertyCode == favoriteProperty.propertyCode) {
                                    property.favoriteProperty = favoriteProperty
                                }
                            }

                        }
                        propertyAdapter.update(allProperties)
                    }
                }

                launch {
                    propertyListViewModel._favoriteListValue.collect {
                        getAllProperties()
                    }
                }

                launch {
                    propertyListViewModel._loadingState.collect { isLoading ->
                        if (isLoading) {
                            binding.progressBar.visibility = View.VISIBLE
                        } else {
                            binding.progressBar.visibility = View.GONE
                        }
                    }
                }

                launch {
                    propertyListViewModel._errorState.collect { error ->
                        if (error.isNotBlank()) {
                            Toast.makeText(
                                this@MainActivity, error, Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

            }
        }
    }

    private fun getAllProperties() {
        propertyListViewModel.getAllProperties()
    }

    private fun getFavoriteProperties() {
        propertyListViewModel.getFavoriteProperties()
    }

    private fun setUpTheRecyclerView() {
        propertyAdapter = PropertyListAdapter(::onClickProperty, ::onClickFav)
        binding.rvProperty.apply {
            adapter = propertyAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun onClickProperty(property: PropertyListItem) {
        val intent = Intent(applicationContext, PropertyDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        applicationContext.startActivity(intent)
    }

    private fun onClickFav(property: PropertyListItem) {
        property.favoriteProperty?.let {
            propertyListViewModel.saveFavoriteProperty(it)
        }

    }
}