package com.example.idealistachallengefranciscogaitan.presentation.list

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.idealistachallengefranciscogaitan.R
import com.example.idealistachallengefranciscogaitan.databinding.ItemPropertyLayoutBinding
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.PropertyListItem
import com.example.idealistachallengefranciscogaitan.utils.buildInflater
import java.text.SimpleDateFormat
import java.util.Calendar

class PropertyListAdapter(
    private var onClickDetail: (PropertyListItem) -> Unit,
    private var onClickFav: (PropertyListItem) -> Unit
) : ListAdapter<PropertyListItem, PropertyListAdapter.ViewHolder>(ScheduleDiffCallback) {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPropertyLayoutBinding.inflate(parent.buildInflater(), parent, false),
            onClickDetail,
            onClickFav
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = getItem(position)
        holder.bind(property)
    }

    class ViewHolder(
        private val binding: ItemPropertyLayoutBinding,
        private val onClickDetail: ((PropertyListItem) -> Unit)? = null,
        private val onClickFav: ((PropertyListItem) -> Unit)? = null,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(property: PropertyListItem): ItemPropertyLayoutBinding {
            return binding.apply {
                tvDescription.text = property.description
                tvAddress.text = property.completeAddress
                tvPrice.text = property.priceInfo?.price?.currencySuffix
                tvPrice.text = binding.root.context.getString(
                    R.string.price,
                    property.priceInfo?.price?.amount?.toInt(),
                    property.priceInfo?.price?.currencySuffix
                )
                setFavorite(property)
                setUpMultimediaAdapter(property)
                setOnClickListeners(property)

            }
        }

        private fun setOnClickListeners(property: PropertyListItem) {
            binding.root.setOnClickListener {
                onClickDetail?.invoke(property)
            }

            binding.rvImages.setOnClickListener {
                onClickDetail?.invoke(property)
            }

            binding.ivFav.setOnClickListener {
                property.favoriteProperty?.let {
                    it.isFavorite = !it.isFavorite
                }
                setFavorite(property)
                onClickFav?.invoke(property)
            }
        }

        private fun ItemPropertyLayoutBinding.setUpMultimediaAdapter(
            property: PropertyListItem
        ) {
            val adapter = PropertyPhotoAdapter()
            rvImages.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            rvImages.adapter = adapter
            property.multimedia?.let {
                adapter.submitList(it.images)
            }
        }

        private fun setFavorite(property: PropertyListItem) {
            property.favoriteProperty?.let {
                if (it.favoriteDate.isNotBlank()) {
                    if (it.isFavorite) {
                        binding.tvFavDate.text = it.favoriteDate
                        binding.tvFavDate.visibility = View.VISIBLE
                    } else {
                        it.favoriteDate = ""
                        binding.tvFavDate.text = it.favoriteDate
                        binding.tvFavDate.visibility = View.GONE
                    }
                } else {
                    if (it.isFavorite) {
                        it.favoriteDate = getCurrentDate()
                        binding.tvFavDate.text = it.favoriteDate
                        binding.tvFavDate.visibility = View.VISIBLE
                    } else {
                        it.favoriteDate = ""
                        binding.tvFavDate.text = it.favoriteDate
                        binding.tvFavDate.visibility = View.VISIBLE
                    }
                }
                binding.ivFav.setImageDrawable(
                    if (it.isFavorite) getDrawable(R.drawable.ic_icon_fav)
                    else getDrawable(R.drawable.ic_non_fav)
                )
            }
        }

        @SuppressLint("SimpleDateFormat")
        private fun getCurrentDate(): String {
            val currentDate = Calendar.getInstance().time
            val formatter = SimpleDateFormat("dd-MMMM-yyyy HH:mm")
            return formatter.format(currentDate)
        }

        private fun getDrawable(drawableId: Int): Drawable? {
            return AppCompatResources.getDrawable(binding.root.context, drawableId)
        }
    }

    object ScheduleDiffCallback : DiffUtil.ItemCallback<PropertyListItem>() {
        override fun areItemsTheSame(
            oldItem: PropertyListItem,
            newItem: PropertyListItem
        ): Boolean = oldItem.propertyCode == newItem.propertyCode

        override fun areContentsTheSame(
            oldItem: PropertyListItem,
            newItem: PropertyListItem
        ): Boolean = oldItem == newItem
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(propertyList: List<PropertyListItem>) {
        submitList(propertyList)
        notifyDataSetChanged()
    }
}