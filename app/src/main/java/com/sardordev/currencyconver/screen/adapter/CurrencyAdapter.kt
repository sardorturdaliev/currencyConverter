package com.sardordev.currencyconver.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.databinding.CardCurrencyItemBinding
import com.sardordev.currencyconver.utils.ClickItemListener

class CurrencyAdapter(val listener: ClickItemListener) :
    ListAdapter<CurrencyModel, CurrencyAdapter.VH>(diff) {

    inner class VH(val binding: CardCurrencyItemBinding) : ViewHolder(binding.root) {

        fun onbind(currencyModel: CurrencyModel) {
            binding.tvCurrencyName.text = currencyModel.Ccy
            binding.tvCurrencyPrise.text = currencyModel.Rate
            binding.tvTransCurrency.text = currencyModel.CcyNm_RU


            itemView.setOnClickListener {
                listener.click(currencyModel)
            }

            binding.imgfavorite.setOnClickListener {
                listener.clickFavorite(currencyModel)
            }

        }

    }


    object diff : DiffUtil.ItemCallback<CurrencyModel>() {
        override fun areItemsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CurrencyModel, newItem: CurrencyModel): Boolean {
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