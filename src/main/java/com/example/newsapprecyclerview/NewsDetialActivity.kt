package com.example.newsapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class NewsDetialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detial)

        val imageId=intent.getIntExtra("imageId",R.drawable.img1)
        val heading=intent.getStringExtra("heading")
        val newsContent=intent.getStringExtra("newsContent")

        val img=findViewById<ImageView>(R.id.newsImage)
        val hd=findViewById<TextView>(R.id.newsHeading)
        val con=findViewById<TextView>(R.id.newsContent)


        img.setImageResource(imageId)
        hd.text=heading
        con.text=newsContent


    }
}