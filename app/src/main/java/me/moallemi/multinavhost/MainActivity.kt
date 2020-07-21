package me.moallemi.multinavhost

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import me.moallemi.multinavhost.navigation.TabManager

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val tabManager: TabManager by lazy { TabManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            tabManager.currentController = tabManager.navHomeController
            if (intent.containsDeepLink()) {
                handleDeepLink()
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        tabManager.switchTab(menuItem.itemId)
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (this.intent.containsDeepLink()) {
            handleDeepLink()
        }
    }

    private fun handleDeepLink() {
        intent.data?.pathSegments?.also { deepLinkPathSegments ->
            when(deepLinkPathSegments.firstOrNull()?.trim()) {
                "dashboard" -> R.id.navigation_dashboard
                "home" ->  R.id.navigation_home
                "notifications" -> R.id.navigation_notifications
                "pages" -> {
                    tabManager.currentController?.navigate(NavigationGraphMainDirections.actionGlobalPageFragment(getPageNumberFromSegments(deepLinkPathSegments), "PageFragment"))
                    null
                }
                else -> null
            }?.also {
                tabManager.switchTab(it)
                bottomNavigationView.menu.findItem(it).isChecked = true
            }
        }
    }

    private fun getPageNumberFromSegments(deepLinkPathSegments: List<String>): Int = if (deepLinkPathSegments.size < 2) 0 else deepLinkPathSegments[1].toIntOrNull() ?: 0

    private fun Intent.containsDeepLink(): Boolean = action == Intent.ACTION_VIEW && data != null
}
