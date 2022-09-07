package com.example.kotlin_lesson

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*


class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        im.setImageResource(intent.getIntExtra("image", R.drawable.ic_fish))
    }
}