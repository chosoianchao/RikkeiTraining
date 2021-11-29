package com.rikkei.tranning.rikkeitraining2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val m001Fragment = M001Fragment()
        fragmentTransaction.replace(R.id.fr_main, m001Fragment, M001Fragment.TAG)
        fragmentTransaction.commit()
    }

    fun showFrg() {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val m002Fragment = M002Fragment()
        fragmentTransaction.replace(R.id.fr_main, m002Fragment, M002Fragment.TAG)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}