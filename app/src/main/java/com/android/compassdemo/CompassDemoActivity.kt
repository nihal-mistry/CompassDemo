package com.android.compassdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.appcomponents.util.CompassUtility
import com.android.compassdemo.databinding.ActivityCompassDemoBinding
import kotlin.math.roundToInt

class CompassDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompassDemoBinding
    private lateinit var compassUtility: CompassUtility

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompassDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compassUtility = CompassUtility.getInstance(this)
        compassUtility.getCompassAngleLiveData().observe(this) {
            binding.tvAngle.text = it.roundToInt().toString()
        }
    }

    override fun onResume() {
        super.onResume()
        compassUtility.startListening()
    }

    override fun onPause() {
        super.onPause()
        compassUtility.stopListening()
    }
}