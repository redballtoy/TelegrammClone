package com.example.redballtoy.telegrammclone

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.redballtoy.telegrammclone.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.*
import com.mikepenz.materialdrawer.widget.AccountHeaderView


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var headerView: AccountHeaderView
    private lateinit var toolbar: Toolbar
    private val profilesUsers = mutableListOf<ProfileDrawerItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    //инициализация функциональности
    private fun initFunc() {
        handleToolbar()
        createDrawer()
        createSimpleProfile()
        createAccountHeader()

    }


    private fun handleToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    private fun createDrawer() {
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            bindingMain.root,
            bindingMain.tbMain,
            R.string.appbar_open,
            R.string.material_drawer_close
        )
        bindingMain.root.addDrawerListener(actionBarDrawerToggle)
    }

    private fun createSimpleProfile() {
        profilesUsers.add(0, ProfileDrawerItem().apply {
            nameText = "Dmitry Sorokin";descriptionText = "redballtoy@gmail.com";
            iconRes = R.drawable.my_logo; identifier = 100
        })
        profilesUsers.add(1, ProfileDrawerItem().apply {
            nameText = "Mike Penz"; descriptionText = "mikepenz@gmail.com"; iconUrl =
            "https://avatars3.githubusercontent.com/u/1476232?v=3&s=460"; identifier = 101
        })
        profilesUsers.add(2, ProfileDrawerItem().apply {
            nameText = "Demo User"; descriptionText = "demo@github.com"; iconUrl =
            "https://avatars2.githubusercontent.com/u/3597376?v=3&s=460"; identifier = 102
        })
        profilesUsers.add(3, ProfileDrawerItem().apply {
            nameText = "Batman"; descriptionText = "batman@gmail.com"; iconRes =
            R.drawable.profile5; identifier = 106; badgeText = "123"
            badgeStyle = BadgeStyle().apply {
                textColor = ColorHolder.fromColor(Color.BLACK)
                color = ColorHolder.fromColor(Color.WHITE)
            }
        })

    }

    private fun createAccountHeader() {
        //Log.d("myLog","${profiles[1].name?.textString.toString()},${profiles[2].name?.textString.toString()} ")
        headerView = AccountHeaderView(this).apply {
            attachToSliderView(bindingMain.slider)
            addProfiles(
                profilesUsers[0],
                profilesUsers[1],
                profilesUsers[2],
                profilesUsers[3]
            )

        }
    }


    //инициализация объектов
    private fun initFields() {
        toolbar = bindingMain.tbMain
    }


}