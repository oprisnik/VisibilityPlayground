package com.example.oprisnik.visibilityplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.ActivityOptions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { startDetailActivity() }
        image.apply {
            setImageDrawable(DebugDrawable())
            setOnClickListener { invalidate() }
        }
    }

    fun startDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        var bundle: Bundle? = null
        if (enableTransitions.isChecked) {
        bundle = ActivityOptions.makeSceneTransitionAnimation(
                this,
                image,
                "transition").toBundle()

        }
        startActivity(intent, bundle)
    }
}
