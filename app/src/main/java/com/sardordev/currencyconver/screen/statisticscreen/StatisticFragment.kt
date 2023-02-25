package com.sardordev.currencyconver.screen.statisticscreen

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.sardordev.currencyconver.R
import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.databinding.FragmentStatisticBinding
import com.sardordev.currencyconver.utils.Uiutil
import com.sardordev.currencyconver.viewmodel.StatisticViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class StatisticFragment : Fragment() {
    private val binding by lazy { FragmentStatisticBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<StatisticViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCurrencyList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        lifecycleScope.launchWhenCreated {
            viewModel.converList.collectLatest {
                when (it) {
                    Uiutil.Empty -> Unit
                    is Uiutil.Error -> {

                    }
                    Uiutil.Loading -> {

                    }
                    is Uiutil.Success<*> -> {
                        val currencylist = it.data as List<CurrencyModel>
//
                        getChart(currencylist)
//                        Log.d("ZZZ",currencylist.toString())


                    }
                }
            }

        }




        return binding.root
    }

    private fun getChart(it: List<CurrencyModel>) {
        val plist = ArrayList<PieEntry>()
        for (i in 0 until it.size) {
            plist.add(PieEntry(it[i].Rate!!.toFloat(), "${it.get(i).Ccy}"))
        }
        val pieDataSet = PieDataSet(plist, "")
        val piedata = PieData(pieDataSet)
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        binding.piechartBudget.data = piedata
        piedata.setValueTextSize(13f)

        Log.d("PPP", plist.toString())
    }


//    private fun getBar() {
//
//        val list = ArrayList<BarEntry>()
//        list.add(BarEntry(100f, 100f,"usd"))
//        list.add(BarEntry(101f, 101f))
//        list.add(BarEntry(102f, 102f))
//        list.add(BarEntry(103f, 103f))
//
//        val barDataSet = BarDataSet(list, "List")
//
//        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
//
//        barDataSet.valueTextColor = Color.BLACK
//        val barData = BarData(barDataSet)
//
//        binding.piechartBudget.data = barData
//        binding.piechartBudget.animateY(2000)
//
//
//    }
}