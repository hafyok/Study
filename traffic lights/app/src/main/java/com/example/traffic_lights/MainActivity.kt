package com.example.traffic_lights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    var semaforeGrey: ImageView? = null
    var imageArray: IntArray =
        intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    var counter: Int = 0
    var timer: Timer? = null
    var is_run: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        semaforeGrey = findViewById(R.id.semaforGrey)
    }

    fun onClickStartStop(view: View) {
        view as ImageButton
        if (!is_run) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            is_run = true
        } else {
            semaforeGrey?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_stop)
            timer?.cancel()
            is_run = false
            counter = 0

        }
    }

    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread{
                    semaforeGrey?.setImageResource(imageArray[counter])
                    counter++
                    if(counter == 3) counter = 0
                }
            }

        }, 0, 1000)
    }
}