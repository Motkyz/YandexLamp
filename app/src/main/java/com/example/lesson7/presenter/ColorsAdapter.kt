package com.example.lesson7.presenter

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson7.data.ColorParser
import com.example.lesson7.data.model.ColorInfo
import com.example.lesson7.databinding.ItemColorBinding

class ColorsAdapter(
    private val onColorItemClick: (ColorInfo) -> Unit
): ListAdapter<ColorInfo, ColorsAdapter.ColorViewHolder>(ColorDivUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ColorViewHolder {
        val context =parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemColorBinding.inflate(inflater, parent, false)

        return ColorViewHolder(
            onColorItemClick,
            binding
        )
    }

    override fun onBindViewHolder(
        holder: ColorViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class ColorViewHolder(
        private val onColorItemClick: (ColorInfo) -> Unit,
        private val binding: ItemColorBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(colorInfo: ColorInfo) = with(binding){
            val color = ColorParser.parseColor(colorInfo.color)

            colorItem.background.setTint(color)
            colorItem.setOnClickListener {
                onColorItemClick(colorInfo)
            }
        }
    }

    private class ColorDivUtil: DiffUtil.ItemCallback<ColorInfo>() {
        override fun areItemsTheSame(
            oldItem: ColorInfo,
            newItem: ColorInfo
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ColorInfo,
            newItem: ColorInfo
        ): Boolean =
            oldItem == newItem
    }
}