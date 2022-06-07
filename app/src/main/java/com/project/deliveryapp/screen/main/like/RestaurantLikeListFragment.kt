package com.project.deliveryapp.screen.main.like

import com.project.deliveryapp.databinding.FragmentRestaurantLikeListBinding
import com.project.deliveryapp.screen.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantLikeListFragment: BaseFragment<RestaurantLikeListViewModel, FragmentRestaurantLikeListBinding>() {

    override fun getViewBinding(): FragmentRestaurantLikeListBinding = FragmentRestaurantLikeListBinding.inflate(layoutInflater)

    override val viewModel by viewModel<RestaurantLikeListViewModel>()

    override fun observeData() {

    }

    companion object {
        fun newInstance() = RestaurantLikeListFragment()
        const val TAG = "RestaurantLikeListFragment"
    }

}