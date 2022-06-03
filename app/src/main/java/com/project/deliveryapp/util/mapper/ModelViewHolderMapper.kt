package com.project.deliveryapp.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.deliveryapp.databinding.ViewholderEmptyBinding
import com.project.deliveryapp.databinding.ViewholderFoodMenuBinding
import com.project.deliveryapp.databinding.ViewholderRestaurantBinding
import com.project.deliveryapp.model.CellType
import com.project.deliveryapp.model.Model
import com.project.deliveryapp.screen.base.BaseViewModel
import com.project.deliveryapp.util.provider.ResourcesProvider
import com.project.deliveryapp.widget.adapter.viewholder.EmptyViewHolder
import com.project.deliveryapp.widget.adapter.viewholder.ModelViewHolder
import com.project.deliveryapp.widget.adapter.viewholder.food.FoodMenuViewHolder
import com.project.deliveryapp.widget.adapter.viewholder.restaurant.RestaurantViewHolder

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun<M: Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ):ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.EMPTY_CELL -> EmptyViewHolder(
                ViewholderEmptyBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
            CellType.RESTAURANT_CELL -> RestaurantViewHolder(
                ViewholderRestaurantBinding.inflate(inflater, parent, false),
                viewModel, resourcesProvider
            )
            CellType.FOOD_CELL -> FoodMenuViewHolder(
                ViewholderFoodMenuBinding.inflate(inflater, parent, false),
                viewModel,
                resourcesProvider
            )
        }
        return viewHolder as ModelViewHolder<M>
    }
}