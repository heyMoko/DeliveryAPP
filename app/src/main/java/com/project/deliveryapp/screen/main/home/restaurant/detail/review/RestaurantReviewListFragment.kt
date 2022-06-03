package com.project.deliveryapp.screen.main.home.restaurant.detail.review

import androidx.core.os.bundleOf
import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.databinding.FragmentListBinding
import com.project.deliveryapp.screen.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantReviewListFragment: BaseFragment<RestaurantReviewListViewModel, FragmentListBinding>() {

    override fun getViewBinding(): FragmentListBinding = FragmentListBinding.inflate(layoutInflater)

    override val viewModel by viewModel<RestaurantReviewListViewModel>()

    override fun observeData() {

    }

    companion object {

        const val RESTAURANT_ID_KEY = "restaurantId"

        fun newInstance(restaurantId: Long): RestaurantReviewListFragment {
            val bundle = bundleOf(
                RESTAURANT_ID_KEY to restaurantId
            )
            return RestaurantReviewListFragment().apply {
                arguments = bundle
            }
        }
    }
}