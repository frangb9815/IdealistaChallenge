package com.example.idealistachallengefranciscogaitan.presentation.list

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.idealistachallengefranciscogaitan.R
import com.example.idealistachallengefranciscogaitan.databinding.ItemPhotoLayoutBinding
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Image
import com.example.idealistachallengefranciscogaitan.domain.model.propertyList.Multimedia
import com.example.idealistachallengefranciscogaitan.utils.buildInflater

class PropertyPhotoAdapter : ListAdapter<Image, PropertyPhotoAdapter.ImageViewHolder>(ScheduleDiffCallback) {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemPhotoLayoutBinding.inflate(parent.buildInflater(), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val property = getItem(position)
        holder.bind(property, position + 1, itemCount)
    }

    class ImageViewHolder(
        private val binding: ItemPhotoLayoutBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image, position: Int, totalSize: Int): ItemPhotoLayoutBinding {
            return binding.apply {
                tvRoomName.text = image.tag
                tvPhotoNumber.text = binding.root.context.getString(
                    R.string.photo_position,
                    position,
                    totalSize
                )
                Glide.with(binding.root.context)
                    .load(image.url)
                    .into(ivProperty)
            }
        }
    }

    object ScheduleDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(
            oldItem: Image,
            newItem: Image
        ): Boolean = oldItem.url == newItem.url

        override fun areContentsTheSame(
            oldItem: Image,
            newItem: Image
        ): Boolean = oldItem == newItem
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(multimedia: Multimedia) {
        submitList(multimedia.images)
        notifyDataSetChanged()
    }
}