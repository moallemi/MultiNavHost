package me.moallemi.multinavhost.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_page.buttonNextPage
import kotlinx.android.synthetic.main.fragment_page.message
import me.moallemi.multinavhost.NavigationGraphMainDirections
import me.moallemi.multinavhost.R

class PageFragment : BaseFragment() {

    private var pageNumber: Int? = null
    private var pageParent: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            val passedArguments = PageFragmentArgs.fromBundle(it)
            pageNumber = passedArguments.pageNumber
            pageParent = passedArguments.pageParent
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = "Page number $pageNumber, Parent: $pageParent"

        buttonNextPage.setOnClickListener {
            val action = NavigationGraphMainDirections.ActionGlobalPageFragment(pageNumber!! + 1, "PageFragment")
            view.findNavController().navigate(action)
        }
    }
}