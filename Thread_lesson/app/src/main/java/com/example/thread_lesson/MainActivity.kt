package com.example.thread_lesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var is_run:Boolean = false
    var counter = 0
    var timer: Timer? = null
    fun onClickStartStop(view: View)
    {
        view as Button
        if(!is_run){
            startStop()
            is_run = true
        }
    /*    else
        {
            imSemafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
            counter = 0
        }*/
    }
    fun startStop() {
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread{
                    counter++
                }
            }

        },0,1000)
    }
}