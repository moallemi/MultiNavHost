package me.moallemi.multinavhost.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_page.buttonNextPage
import kotlinx.android.synthetic.main.fragment_page.message
import me.moallemi.multinavhost.NavigationGraphMainDirections
import me.moallemi.multinavhost.R

class PageFragment : BaseFragment() {

    private val fragmentArgs: PageFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = "Page number ${fragmentArgs.pageNumber}, Parent: ${fragmentArgs.pageParent}"

        buttonNextPage.setOnClickListener {
            view.findNavController().navigate(
                    NavigationGraphMainDirections.actionGlobalPageFragment(fragmentArgs.pageNumber + 1, "PageFragment")
            )
        }
    }
}