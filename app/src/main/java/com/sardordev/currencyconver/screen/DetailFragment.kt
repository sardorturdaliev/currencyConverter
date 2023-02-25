package com.sardordev.currencyconver.screen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sardordev.currencyconver.databinding.FragmentDetailBinding
import com.sardordev.currencyconver.`object`.GetObject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val binding by lazy { FragmentDetailBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        initData()


        binding.btncalculate.setOnClickListener {
            if (binding.edtcost.text.isNotEmpty()) {
                val sum =
                    calculateSum(
                        binding.edtcost.text.toString(),
                        GetObject.currencyModel.Rate.toString()
                    )

                binding.tvSum.text = sum
            }
        }


        return binding.root
    }

    private fun initData() {
        binding.tvCurrencyName.text = GetObject.currencyModel.Ccy
        binding.tvCurrencyCost.text = GetObject.currencyModel.Rate


    }


    private fun calculateSum(number: String, number2: String): String {
        return (number.toFloat()* number2.toFloat()).toString()
    }







}