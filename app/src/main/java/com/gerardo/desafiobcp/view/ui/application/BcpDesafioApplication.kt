package com.gerardo.desafiobcp.view.ui.application

import android.app.Application
import io.paperdb.Paper

open class BcpDesafioApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}