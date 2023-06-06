package com.example.newsapprecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView:RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    supportActionBar?.hide()

        //recyclerview wala lateint var ko intialize kiya hai
        myRecyclerView=findViewById(R.id.recyclerView)

        //newsapp ki image store kar rha hai
        val newsImageArray= arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
        )

        //newsAPP ki news ki sari heading
        val newsHeadingArray= arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        )

        val newsContent= arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content)
        )

        //this is used to set the hav bhav of inside recyclerview(matlab vertical ya horizontally ya uniform grid scrolling kasa hoga wow dekhya ga issma
        myRecyclerView.layoutManager=LinearLayoutManager(this)

        //news array list ko initialize kara ga
        newsArrayList= arrayListOf<News>()

        //har ek image or heading ko daal rha hai for loop ki help sa
        for(index in newsImageArray.indices){

            val news=News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter=MyAdapter(newsArrayList,this)
       myRecyclerView.adapter=myAdapter

        myAdapter.onItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                //on clicking each item which action you want to perform

                val intent=Intent(applicationContext,NewsDetialActivity::class.java)

                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("newsContent",newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })


    }
}