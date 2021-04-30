package com.example.redballtoy.telegrammclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.redballtoy.telegrammclone.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.util.DrawerNavigationUI
import com.mikepenz.materialdrawer.widget.AccountHeaderView


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var draverNavigation: DrawerNavigationUI
    private lateinit var header: AccountHeaderView
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    //инициализация функциональности
    private fun initFunc() {
        setSupportActionBar(toolbar)
    }

    //инициализация объектов
    private fun initFields() {
        toolbar=bindingMain.tbMain
    }


}