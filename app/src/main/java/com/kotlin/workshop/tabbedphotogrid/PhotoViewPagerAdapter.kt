package com.kotlin.workshop.tabbedphotogrid

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PhotoViewPagerAdapter (fragmentManager: FragmentManager, private val animals: List<PhotoSource>)
    : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = PhotoGridFragment.getInstance(animals[position])

    override fun getCount() = animals.size

    override fun getPageTitle(position: Int): CharSequence? = animals[position].name

}