package com.project.deliveryapp.screen.main.home.restaurant.detail.menu

import androidx.core.os.bundleOf
import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.databinding.FragmentListBinding
import com.project.deliveryapp.model.restaurant.food.FoodModel
import com.project.deliveryapp.screen.base.BaseFragment
import com.project.deliveryapp.util.provider.ResourcesProvider
import com.project.deliveryapp.widget.adapter.ModelRecyclerAdapter
import com.project.deliveryapp.widget.adapter.listener.AdapterListener
import com.project.deliveryapp.widget.adapter.listener.restaurant.FoodMenuListListener
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class RestaurantMenuListFragment: BaseFragment<RestaurantMenuListViewModel, FragmentListBinding>() {

    override fun getViewBinding(): FragmentListBinding = FragmentListBinding.inflate(layoutInflater)

    private val restaurantId by lazy { arguments?.getLong(RESTAURANT_ID_KEY, -1) }
    private val restaurantFoodList by lazy { arguments?.getParcelableArrayList<RestaurantFoodEntity>(FOOD_LIST_KEY)!! }

    override val viewModel by viewModel<RestaurantMenuListViewModel> {
        parametersOf(
            restaurantId,
            restaurantFoodList
        )
    }

    private val resourceProvider by inject<ResourcesProvider>()

    private val adapter by lazy {
        ModelRecyclerAdapter<FoodModel, RestaurantMenuListViewModel>(
            listOf(),
            viewModel,
            resourceProvider,
            adapterListener = object : FoodMenuListListener {
                override fun onClickItem(model: FoodModel) {
                    viewModel.insertMenuInBasket(model)
                }
            }
        )
    }

    override fun initViews() {
        binding.recyclerView.adapter = adapter
    }

    override fun observeData() = viewModel.restaurantFoodListLiveData.observe(this) {
        adapter.submitList(it)
    }

    companion object {

        const val RESTAURANT_ID_KEY = "restaurantId"
        const val FOOD_LIST_KEY = "foodList"

        fun newInstance(restaurantId: Long, foodList: ArrayList<RestaurantFoodEntity>): RestaurantMenuListFragment {
            val bundle = bundleOf(
                RESTAURANT_ID_KEY to restaurantId,
                FOOD_LIST_KEY to foodList
            )
            return RestaurantMenuListFragment().apply {
                arguments = bundle
            }
        }
    }
}