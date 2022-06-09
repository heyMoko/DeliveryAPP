package com.project.deliveryapp.screen.main.like

import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.project.deliveryapp.databinding.FragmentRestaurantLikeListBinding
import com.project.deliveryapp.model.restaurant.RestaurantModel
import com.project.deliveryapp.screen.base.BaseFragment
import com.project.deliveryapp.screen.main.home.restaurant.detail.RestaurantDetailActivity
import com.project.deliveryapp.util.provider.ResourcesProvider
import com.project.deliveryapp.widget.adapter.ModelRecyclerAdapter
import com.project.deliveryapp.widget.adapter.listener.restaurant.RestaurantLikeListListener
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantLikeListFragment: BaseFragment<RestaurantLikeListViewModel, FragmentRestaurantLikeListBinding>() {

    override fun getViewBinding(): FragmentRestaurantLikeListBinding = FragmentRestaurantLikeListBinding.inflate(layoutInflater)

    override val viewModel by viewModel<RestaurantLikeListViewModel>()

    private val resourceProvider by inject<ResourcesProvider>()

    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantLikeListViewModel>(listOf(), viewModel, resourceProvider, adapterListener = object :
            RestaurantLikeListListener {

            override fun onDislikeItem(model: RestaurantModel) {
                viewModel.dislikeRestaurant(model.toEntity())
            }

            override fun onClickItem(model: RestaurantModel) {
                startActivity(
                    RestaurantDetailActivity.newIntent(requireContext(), model.toEntity())
                )
            }
        })
    }

    override fun initViews() {
        binding.recyclerView.adapter = adapter
    }

    override fun observeData() = viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
        checkListEmpty(it)
    }

    private fun checkListEmpty(restaurantList: List<RestaurantModel>) {
        val isEmpty = restaurantList.isEmpty()
        binding.recyclerView.isGone = isEmpty
        binding.emptyResultTextView.isVisible = isEmpty
        if (!isEmpty) {
            adapter.submitList(restaurantList)
        }
    }

    companion object {
        fun newInstance() = RestaurantLikeListFragment()
        const val TAG = "RestaurantLikeListFragment"
    }

}