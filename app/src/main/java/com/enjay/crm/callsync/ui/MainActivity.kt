package com.enjay.crm.callsync.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavGraph
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.enjay.crm.callsync.EnjayCallSyncApp
import com.enjay.crm.callsync.R
import com.enjay.crm.callsync.core.AppPermissions
import com.enjay.crm.callsync.databinding.ActivityMainBinding
import com.enjay.crm.callsync.service.CallMonitoringServiceManager
import com.enjay.crm.callsync.util.applyInsetPadding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var bottomNavVisible = true
    private val permissionStateProvider by lazy {
        (application as EnjayCallSyncApp).appContainer.permissionStateProvider
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowInsetsControllerCompat(window, binding.root).isAppearanceLightStatusBars = true

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        configureStartDestination(navController.navInflater.inflate(R.navigation.main_nav_graph))

        setSupportActionBar(binding.toolbar)
        applyWindowInsets()
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.permissionsFragment,
                R.id.callsFragment,
                R.id.leadsFragment,
                R.id.moreFragment,
            ),
        )

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            if (navController.currentDestination?.id == item.itemId) {
                true
            } else {
                item.onNavDestinationSelected(navController)
            }
        }
        binding.bottomNavigation.setOnItemReselectedListener { }
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val showBottomNav = destination.id != R.id.permissionsFragment &&
                destination.id != R.id.addLeadFragment &&
                destination.id != R.id.leadDetailFragment &&
                destination.id != R.id.postCallDetailFragment
            setBottomNavVisible(showBottomNav)
            binding.navHostFragment.visibility = View.VISIBLE
            binding.startupLoadingOverlay.visibility = View.GONE
            if (showBottomNav) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }

            val titleRes = when (destination.id) {
                R.id.permissionsFragment -> R.string.title_permissions
                R.id.callsFragment -> R.string.tab_calls
                R.id.leadsFragment -> R.string.tab_leads
                R.id.moreFragment -> R.string.tab_more
                R.id.addLeadFragment -> R.string.title_add_lead
                R.id.leadDetailFragment -> R.string.title_lead_detail
                R.id.postCallDetailFragment -> R.string.title_post_call_detail
                else -> R.string.app_name
            }
            binding.toolbar.setTitle(titleRes)
            CallMonitoringServiceManager.sync(this, permissionStateProvider)
        }
    }

    private fun configureStartDestination(graph: NavGraph) {
        val allPermissionsGranted = AppPermissions.requiredPermissions().all(permissionStateProvider::isPermissionGranted)
        graph.setStartDestination(if (allPermissionsGranted) R.id.callsFragment else R.id.permissionsFragment)
        navController.setGraph(graph, null)
    }

    private fun applyWindowInsets() {
        binding.root.applyInsetPadding(top = true, bottom = false)
    }

    private fun setBottomNavVisible(show: Boolean) {
        if (bottomNavVisible == show) return
        bottomNavVisible = show
        if (show) {
            binding.bottomNavigation.visibility = View.VISIBLE
            binding.bottomNavigation.animate()
                .translationY(0f)
                .alpha(1f)
                .setDuration(220L)
                .start()
        } else {
            binding.bottomNavigation.animate()
                .translationY(binding.bottomNavigation.height.toFloat())
                .alpha(0f)
                .setDuration(180L)
                .withEndAction { binding.bottomNavigation.visibility = View.GONE }
                .start()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        CallMonitoringServiceManager.sync(this, permissionStateProvider)
    }
}
