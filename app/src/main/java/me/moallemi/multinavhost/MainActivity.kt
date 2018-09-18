package me.moallemi.multinavhost

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import kotlinx.android.synthetic.main.activity_main.dashboardTab
import kotlinx.android.synthetic.main.activity_main.dashboardTabContainer
import kotlinx.android.synthetic.main.activity_main.homeTab
import kotlinx.android.synthetic.main.activity_main.homeTabContainer
import kotlinx.android.synthetic.main.activity_main.notificationsTab
import kotlinx.android.synthetic.main.activity_main.notificationsTabContainer

class MainActivity : AppCompatActivity() {

    var currentController: NavController? = null

    val navHomeController: NavController by lazy { findNavController(R.id.homeTab) }
    val navHomeFragment: Fragment by lazy { homeTab }
    val navDashboardController: NavController by lazy { findNavController(R.id.dashboardTab) }
    val navDashboardFragment: Fragment by lazy { dashboardTab }
    val navNotificationController: NavController by lazy { findNavController(R.id.notificationsTab) }
    val navNotificationFragment: Fragment by lazy { notificationsTab }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navigation_home -> {
                currentController = navHomeController

                homeTabContainer.visibility = View.VISIBLE
                dashboardTabContainer.visibility = View.INVISIBLE
                notificationsTabContainer.visibility = View.INVISIBLE
            }
            R.id.navigation_dashboard -> {
                currentController = navDashboardController

                homeTabContainer.visibility = View.INVISIBLE
                dashboardTabContainer.visibility = View.VISIBLE
                notificationsTabContainer.visibility = View.INVISIBLE
            }
            R.id.navigation_notifications -> {
                currentController = navNotificationController

                homeTabContainer.visibility = View.INVISIBLE
                dashboardTabContainer.visibility = View.INVISIBLE
                notificationsTabContainer.visibility = View.VISIBLE
            }
        }
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentController = navHomeController

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeTabContainer.visibility = View.VISIBLE
        dashboardTabContainer.visibility = View.INVISIBLE
        notificationsTabContainer.visibility = View.INVISIBLE
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    override fun onBackPressed() {
        currentController
                ?.let { if (it.popBackStack().not()) finish() }
                ?: run { finish() }
    }
}
