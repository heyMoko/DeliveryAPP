package com.project.deliveryapp.widget.adapter.viewholder.food

import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.project.deliveryapp.R
import com.project.deliveryapp.databinding.ViewholderFoodMenuBinding
import com.project.deliveryapp.extensions.clear
import com.project.deliveryapp.extensions.load
import com.project.deliveryapp.model.restaurant.food.FoodModel
import com.project.deliveryapp.screen.base.BaseViewModel
import com.project.deliveryapp.util.provider.ResourcesProvider
import com.project.deliveryapp.widget.adapter.listener.AdapterListener
import com.project.deliveryapp.widget.adapter.listener.restaurant.FoodMenuListListener
import com.project.deliveryapp.widget.adapter.viewholder.ModelViewHolder

class FoodMenuViewHolder(
    private val binding: ViewholderFoodMenuBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<FoodModel>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
        foodImage.clear()
    }

    override fun bindData(model: FoodModel) {
        super.bindData(model)
        with(binding) {
            foodImage.load(model.imageUrl, 24f, CenterCrop())
            foodTitleText.text = model.title
            foodDescriptionText.text = model.description
            priceText.text = resourcesProvider.getString(R.string.price, model.price)
        }
    }

    override fun bindViews(model: FoodModel, adapterListener: AdapterListener) {
        if (adapterListener is FoodMenuListListener) {
            binding.root.setOnClickListener {
                adapterListener.onClickItem(model)
            }
        }
    }
}