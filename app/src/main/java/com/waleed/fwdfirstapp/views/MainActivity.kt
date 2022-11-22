package com.waleed.fwdfirstapp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.waleed.fwdfirstapp.R
import com.waleed.fwdfirstapp.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val toolbar = mainActivityBinding.toolbar
        setSupportActionBar(toolbar)

//        val navigationController: NavController = this.findNavController(R.id.navigation)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation) as NavHostFragment
        val navigationController = navHostFragment.navController



        NavigationUI.setupActionBarWithNavController(this, navigationController)
        appBarConfiguration = AppBarConfiguration(navigationController.graph)

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navigation).navigateUp(appBarConfiguration)
    }

}