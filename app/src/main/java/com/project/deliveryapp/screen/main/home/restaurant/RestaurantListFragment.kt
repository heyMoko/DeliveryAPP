package com.project.deliveryapp.screen.main.home.restaurant

import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import com.project.deliveryapp.databinding.FragmentRestaurantListBinding
import com.project.deliveryapp.model.restaurant.RestaurantModel
import com.project.deliveryapp.screen.base.BaseFragment
import com.project.deliveryapp.util.provider.ResourcesProvider
import com.project.deliveryapp.widget.adapter.ModelRecyclerAdapter
import com.project.deliveryapp.widget.adapter.listener.restaurant.RestaurantListListener
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RestaurantListFragment: BaseFragment<RestaurantListViewModel, FragmentRestaurantListBinding>() {

    private val restaurantCategory by lazy { arguments?.getSerializable(RESTAURANT_CATEGORY_KEY) as RestaurantCategory }

    override val viewModel by viewModel<RestaurantListViewModel> { parametersOf(restaurantCategory) }

    override fun getViewBinding(): FragmentRestaurantListBinding = FragmentRestaurantListBinding.inflate(layoutInflater)

    private val resourceProvider by inject<ResourcesProvider>()

    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantListViewModel>(
            listOf(), viewModel, resourceProvider, adapterListener = object: RestaurantListListener {
            override fun onClickItem(model: RestaurantModel) {
                Toast.makeText(requireContext(), "$model", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun initViews() = with(binding) {
        recyclerView.adapter = adapter
    }

    override fun observeData() = viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
        adapter.submitList(it)
    }

    companion object {
        const val RESTAURANT_CATEGORY_KEY = "restaurantCategory"

        fun newInstance(restaurantCategory: RestaurantCategory): RestaurantListFragment {
            return RestaurantListFragment().apply {
                arguments = bundleOf(
                    RESTAURANT_CATEGORY_KEY to restaurantCategory
                )
            }
        }
    }

}