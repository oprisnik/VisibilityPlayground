package com.example.oprisnik.visibilityplayground

import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        image2.setImageDrawable(ColorDrawable(0xff0000ff.toInt()))

        getWindow().setSharedElementEnterTransition(ChangeBounds())
    }
}
