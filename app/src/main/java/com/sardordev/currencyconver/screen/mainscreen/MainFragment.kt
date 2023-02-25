package com.sardordev.currencyconver.screen.mainscreen

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationBarView
import com.sardordev.currencyconver.R
import com.sardordev.currencyconver.databinding.FragmentMainBinding
import com.sardordev.currencyconver.screen.HomeFragment
import com.sardordev.currencyconver.screen.adapter.VPagerAdapter
import com.sardordev.currencyconver.screen.favoritescreen.FavoriteFragment
import com.sardordev.currencyconver.screen.statisticscreen.StatisticFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {
    private val binding by lazy { FragmentMainBinding.inflate(layoutInflater) }
    private val listFragment = ArrayList<Fragment>()
    private lateinit var vPagerAdapter: VPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listFragment.add(HomeFragment())
        listFragment.add(FavoriteFragment())
        listFragment.add(StatisticFragment())

        vPagerAdapter = VPagerAdapter(requireActivity(), list = listFragment)

        binding.viewpager.adapter = vPagerAdapter
        binding.viewpager.isUserInputEnabled = false

        initBottomNav()
        initViewPagetPos()



        return binding.root
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menuhome -> {
                    binding.viewpager.currentItem = 0
                }
                R.id.menufavorite -> {
                    binding.viewpager.currentItem = 1
                }
                R.id.menustatistic -> {
                    binding.viewpager.currentItem = 2
                }
            }
            true
        }
    }

    private fun initViewPagetPos() {

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {


            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        binding.bottomNav.selectedItemId = R.id.menuhome
                    }
                    1 -> {
                        binding.bottomNav.selectedItemId = R.id.menufavorite
                    }
                    2 -> {
                        binding.bottomNav.selectedItemId = R.id.menustatistic
                    }
                }
            }

        })

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding.viewpager.isSaveEnabled = false
    }
}