package com.kotlin.workshop.tabbedphotogrid

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ActivityPhotoGrid : AppCompatActivity() {

    private val viewPager : ViewPager by lazy { findViewById<ViewPager>(R.id.viewpager) }
    private val tabLayout : TabLayout by lazy { findViewById<TabLayout>(R.id.tabs) }
    private val animals = listOf(
            PhotoSource.Dogs(),
            PhotoSource.Cats(),
            PhotoSource.Ducks(),
            PhotoSource.Rabbits())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = PhotoViewPagerAdapter(supportFragmentManager, animals)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
