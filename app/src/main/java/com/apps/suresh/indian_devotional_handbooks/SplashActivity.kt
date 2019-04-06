package com.apps.suresh.indian_devotional_handbooks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, DevotionalHandBooksListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
