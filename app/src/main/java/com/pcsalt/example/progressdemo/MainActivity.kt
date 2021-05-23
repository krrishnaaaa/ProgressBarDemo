package com.pcsalt.example.progressdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pcsalt.example.progressdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvProgress.text = "0/100..."
        showProgress()
    }

    private fun showProgress() {
        handler.postDelayed({
            val progress = binding.pbDetails.progress + 10
            binding.tvProgress.text = "$progress/100..."
            binding.pbDetails.progress = progress

            if (progress < 100) {
                showProgress()
            } else {
                binding.tvProgress.text = "Download/Initialization Completed"
                binding.pbDetails.visibility = View.GONE
            }
        }, 900)
    }
}