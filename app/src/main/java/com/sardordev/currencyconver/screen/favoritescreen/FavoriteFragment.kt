package com.sardordev.currencyconver.screen.favoritescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sardordev.currencyconver.databinding.FragmentFavoriteBinding
import com.sardordev.currencyconver.screen.adapter.FavoriteAdapter
import com.sardordev.currencyconver.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private val binding by lazy { FragmentFavoriteBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<FavoriteViewModel>()
    private lateinit var favoriteAdapter: FavoriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        favoriteAdapter = FavoriteAdapter()

        viewModel.allSavedCurrency.observe(viewLifecycleOwner, Observer {
            favoriteAdapter.submitList(it)
            binding.rvfavorite.apply {
                adapter = favoriteAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        })





        return binding.root
    }
}