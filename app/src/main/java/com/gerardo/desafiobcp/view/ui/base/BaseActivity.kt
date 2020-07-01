package com.gerardo.desafiobcp.view.ui.base

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.gerardo.desafiobcp.R
import com.gerardo.desafiobcp.view.ui.application.BcpDesafioApplication


abstract class BaseActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView())
        onCreate()
        BcpDesafioApplication.addActivity(this)
    }

    @SuppressLint("MissingSuperCall")
    override fun onDestroy() {
        super.onDestroy()
        BcpDesafioApplication.removeActivity(this)
    }

    @SuppressLint("PrivateResource")
    protected fun setSupportActionBar(title: String): ActionBar {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val green = ContextCompat.getColor(this, R.color.colorPrimary)

        toolbar?.setTitleTextColor(green)

        val drawable = ContextCompat.getDrawable(this, R.drawable.arrow_back_white_24dp)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable?.colorFilter = BlendModeColorFilter(green, BlendMode.SRC_ATOP)
        } else {
            drawable?.setColorFilter(green, PorterDuff.Mode.SRC_ATOP)
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(drawable)
        supportActionBar!!.title = title

        return supportActionBar!!
    }

    fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            if (drawerToggle != null) {
                return drawerToggle!!.onOptionsItemSelected(item)
            } else onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        if (drawerToggle != null)
            drawerToggle!!.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (drawerToggle != null)
            drawerToggle!!.onConfigurationChanged(newConfig)
    }

    @SuppressLint("RtlHardcoded")
    override fun onBackPressed() {
        if (drawerLayout != null) {
            if (drawerLayout!!.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout!!.closeDrawers()
                return
            }
        }
        super.onBackPressed()
    }

    abstract fun getView(): Int

    open fun onCreate() {}

    interface SimpleNavigationItemSelectedListener {
        fun onNavigationItemSelected(item: MenuItem)
    }

}