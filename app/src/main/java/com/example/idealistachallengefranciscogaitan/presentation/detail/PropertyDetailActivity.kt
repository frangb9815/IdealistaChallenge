package com.example.idealistachallengefranciscogaitan.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idealistachallengefranciscogaitan.R
import com.example.idealistachallengefranciscogaitan.databinding.ActivityDetailBinding
import com.example.idealistachallengefranciscogaitan.domain.model.propertyDetail.toImageDomain
import com.example.idealistachallengefranciscogaitan.presentation.list.PropertyPhotoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PropertyDetailActivity : AppCompatActivity() {

    private val propertyDetailViewModel: PropertyDetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    private lateinit var propertyPhotoAdapter: PropertyPhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTheRecyclerView()
        getPropertyDetail()
    }

    private fun getPropertyDetail() {
        lifecycleScope.launch {
            propertyDetailViewModel.getPropertyDetail()
            propertyDetailViewModel._propertyDetailValue.collectLatest { propertyDetailValue ->
                if (propertyDetailValue.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                    if (propertyDetailValue.error.isNotBlank()) {
                        Toast.makeText(
                            this@PropertyDetailActivity,
                            propertyDetailValue.error,
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        propertyDetailValue.propertyDetail?.let {
                            it.multimedia.let { imageList ->
                                propertyPhotoAdapter.submitList(imageList.toImageDomain())
                            }
                            binding.apply {
                                tvDescription.text = it.propertyComment
                                tvPrice.text = binding.root.context.getString(
                                    R.string.price_detail,
                                    it.priceInfo.amount.toInt(),
                                    it.priceInfo.currencySuffix
                                )
                                tvAddress.text = binding.root.context.getString(
                                    R.string.address_detail,
                                    it.ubication.latitude,
                                    it.ubication.longitude
                                )
                                tvRooms.text = binding.root.context.getString(
                                    R.string.rooms_detail,
                                    it.moreCharacteristics.roomNumber
                                )
                                tvBathrooms.text = binding.root.context.getString(
                                    R.string.bathrooms_detail,
                                    it.moreCharacteristics.bathNumber
                                )
                                tvStatus.text = binding.root.context.getString(
                                    R.string.status_detail,
                                    it.moreCharacteristics.status
                                )
                                tvEnergy.text = binding.root.context.getString(
                                    R.string.energy_detail,
                                    it.energyCertification.energyConsumption.type
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setUpTheRecyclerView() {
        propertyPhotoAdapter = PropertyPhotoAdapter()
        binding.rvImages.apply {
            adapter = propertyPhotoAdapter
            layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}