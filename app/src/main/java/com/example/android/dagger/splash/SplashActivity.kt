package com.example.android.dagger.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onResume() {
        super.onResume()
        startActivity(viewModel.getActivityIntent(this))
        finish()
    }
}