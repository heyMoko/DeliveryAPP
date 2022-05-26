package com.project.deliveryapp.screen.main.my

import com.project.deliveryapp.databinding.FragmentMyBinding
import com.project.deliveryapp.screen.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFragment: BaseFragment<MyViewModel, FragmentMyBinding>() {

    override val viewModel by viewModel<MyViewModel>()

    override fun getViewBinding(): FragmentMyBinding = FragmentMyBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    companion object {
        fun newInstance() = MyFragment()
        const val TAG = "MyFragment"
    }
}