package com.sardordev.currencyconver.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.databinding.CardCurrencyItemBinding
import com.sardordev.currencyconver.utils.ClickItemListener

class FavoriteAdapter() :
    ListAdapter<FaviriteEntity, FavoriteAdapter.VH>(diff) {

    inner class VH(val binding: CardCurrencyItemBinding) : ViewHolder(binding.root) {

        fun onbind(currencyModel: FaviriteEntity) {
            binding.tvCurrencyName.text = currencyModel.currencyName
            binding.tvCurrencyPrise.text = currencyModel.currencyPrice
            binding.tvTransCurrency.text = currencyModel.currencyTranslated

        }

    }


    object diff : DiffUtil.ItemCallback<FaviriteEntity>() {
        override fun areItemsTheSame(oldItem: FaviriteEntity, newItem: FaviriteEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FaviriteEntity, newItem: FaviriteEntity): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        CardCurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onbind(getItem(position))
    }

}