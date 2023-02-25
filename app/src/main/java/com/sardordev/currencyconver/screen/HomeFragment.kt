package com.sardordev.currencyconver.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sardordev.currencyconver.R
import com.sardordev.currencyconver.data.entity.FaviriteEntity
import com.sardordev.currencyconver.data.model.CurrencyModel
import com.sardordev.currencyconver.databinding.FragmentHomeBinding
import com.sardordev.currencyconver.`object`.GetObject
import com.sardordev.currencyconver.screen.adapter.CurrencyAdapter
import com.sardordev.currencyconver.utils.ClickItemListener
import com.sardordev.currencyconver.utils.Uiutil
import com.sardordev.currencyconver.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class HomeFragment : Fragment(), ClickItemListener {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCurrencyList()
        currencyAdapter = CurrencyAdapter(this)
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
                        binding.progressBar.isVisible = true
                    }
                    is Uiutil.Success<*> -> {
                        binding.progressBar.isVisible = false
                        Log.d("DDD", "${it.data}")
                        val currencyList = it.data as List<CurrencyModel>
                        currencyAdapter.submitList(currencyList)
                    }
                }
            }
        }
        initRecycler()
        return binding.root
    }


    private fun initRecycler() {
        binding.rvCurrency.apply {
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun click(currencyModel: CurrencyModel) {
        GetObject.currencyModel = currencyModel
        findNavController().navigate(R.id.detailFragment)
    }

    override fun clickFavorite(currencyModel: CurrencyModel) {
        val favlist = FaviriteEntity(
            0,
            currencyModel.Ccy.toString(),
            currencyModel.Rate.toString(),
            currencyModel.CcyNm_RU.toString()
        )
        Log.d("UUU", favlist.toString())
        viewModel.saveFavoriteData(favlist)
        Toast.makeText(requireContext(), "Saved to Favorite List", Toast.LENGTH_SHORT).show()
    }


}