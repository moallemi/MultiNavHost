package me.moallemi.multinavhost.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.buttonNextPage
import me.moallemi.multinavhost.NavigationGraphMainDirections
import me.moallemi.multinavhost.R

class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action = NavigationGraphMainDirections.actionGlobalPageFragment(1, "HomeFragment")
            view.findNavController().navigate(action)
        }
    }
}