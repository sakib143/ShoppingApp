package com.example.shopingapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.shopingapp.R
import com.example.shopingapp.base.BaseActivity
import com.example.shopingapp.databinding.ActivityHomeBinding
import com.example.shopingapp.databinding.NavHeaderHomeBinding
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    //Navigation ui component related stuff by Sakib Syed
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var navViewHeaderBinding: NavHeaderHomeBinding? = null

    private lateinit var binding: ActivityHomeBinding

    private var drawer_layout: DrawerLayout? = null
    private var navigationDrawer: NavigationView? = null
    private lateinit var toolBar: Toolbar
    private lateinit var ivOpenMenu: TextView
    @Inject
    lateinit var viewmodel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ivOpenMenu = findViewById(R.id.ivOpenMenu)
        drawer_layout = findViewById(R.id.drawer_layout)
        navigationDrawer = findViewById(R.id.navigationDrawer)
        toolBar = findViewById(R.id.toolBar)

        setSupportActionBar(binding.toolBar)
        setNavigation()
        setNavigationHeader()
        setListner()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(binding.drawerLayout) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun setNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
            ), binding.drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationDrawer.setupWithNavController(navController)
    }

    private fun setNavigationHeader() {
        //Setting burger menu header name.
        val viewHeader = binding.navigationDrawer.getHeaderView(0)
        navViewHeaderBinding = NavHeaderHomeBinding.bind(viewHeader)
        viewmodel.userName.observe(this@HomeActivity, onUernameObservable)
        viewmodel.currentDayName.observe(this@HomeActivity, strDayNameObservable)
        viewmodel.strDate.observe(this@HomeActivity, strDataObserver)
        viewmodel.getUserName()
    }

    private fun setListner() {
        ivOpenMenu.setOnClickListener {
            setupActionBarWithNavController(navController, appBarConfiguration)
            binding.navigationDrawer.setupWithNavController(navController)
            drawer_layout?.openDrawer(GravityCompat.START);
        }
    }


    private val onUernameObservable = Observer<String> {
        navViewHeaderBinding?.username = it
    }

    private val strDayNameObservable = Observer<String> {
        navViewHeaderBinding?.currentDayName = it
    }

    private val strDataObserver = Observer<String> {
        navViewHeaderBinding?.strDate = it
    }
}