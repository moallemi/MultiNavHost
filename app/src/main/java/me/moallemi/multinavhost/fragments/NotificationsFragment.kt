package me.moallemi.multinavhost.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_notifications.buttonNextPage
import me.moallemi.multinavhost.NavigationGraphMainDirections
import me.moallemi.multinavhost.R

class NotificationsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action = NavigationGraphMainDirections.actionGlobalPageFragment(1, "NotificationsFragment")
            view.findNavController().navigate(action)
        }
    }
}