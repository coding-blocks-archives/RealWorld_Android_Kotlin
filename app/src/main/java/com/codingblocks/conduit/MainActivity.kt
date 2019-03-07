package com.codingblocks.conduit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.codingblocks.conduit.fragments.article.EditArticleFragment
import com.codingblocks.conduit.fragments.auth.AuthViewModel
import com.codingblocks.conduit.fragments.auth.LoginFragment
import com.codingblocks.conduit.fragments.auth.RegisterFragment
import com.codingblocks.conduit.fragments.home.HomeFragment
import com.codingblocks.conduit.fragments.user.SettingsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.inflateMenu(R.menu.main_drawer_logged_out)

        authViewModel.currentUser.observe(
            { lifecycle },
            { it.token?.run {
                nav_view.menu.clear()
                nav_view.inflateMenu(R.menu.main_drawer_logged_in)
            } }
        )
        nav_view.setNavigationItemSelectedListener(this)

        // Initially show the home fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout_main_container, HomeFragment.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val container = R.id.framelayout_main_container
        with(supportFragmentManager.beginTransaction()) {
            when (item.itemId) {
                R.id.menu_item_home -> replace(container, HomeFragment.newInstance())

                R.id.menu_item_new_article -> replace(container, EditArticleFragment.newInstance())

                R.id.menu_item_settings ->
                    replace(container, SettingsFragment.newInstance())
                        .addToBackStack("settings")

                R.id.menu_item_signin ->
                    replace(container, LoginFragment.newInstance())
                        .addToBackStack("login")

                R.id.menu_item_signup ->
                    replace(container, RegisterFragment.newInstance())
                        .addToBackStack("register")

                else -> replace(container, HomeFragment.newInstance())
            }
        }.commit()

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
