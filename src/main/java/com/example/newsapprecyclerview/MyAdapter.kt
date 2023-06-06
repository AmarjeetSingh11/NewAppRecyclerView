package com.example.newsapprecyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>,var context:Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //we have create variable of type interface
    private lateinit var myListener:onItemClickListener

    //ek interface banya hai
    //interface is like a class which contain only abstract method
    interface onItemClickListener{

        //ab function banya hai hai ek jab item click hoga toh kya hoga function ma
        //item ki poistion baata rhi hai kon si item hum click kar rha hai
        fun onItemClick(position:Int)
    }

    fun onItemClickListener(Listener: onItemClickListener){
        myListener=Listener
    }

    //Note:- layout manager call these methods while it is positioning items within the RecyclerView
    // If Layout manager fails to find a suitable View in all of these Places,it creates
    // one by calling adapter's onCreateViewHolder()method.
    //It then binds the View via onBindViewHolder()if necessary and finally returns it..



    //jab layout manage ko pata nai hai ki data ko khaa lagana hai toh wow ya method ko call kara ga
    //or ya method ek view create kar ka daga according to the need or return kardaga..
    //or ya view create karna ka liya ViewHolder sa help laga kyu ki wow view hold karta hai isliya...


    //to create new view instance when layout manage fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)

        return MyViewHolder(itemView,myListener)
    }

    //data ya item bharna ka liya use hota hai yaa

    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
      val currentItem=newsArrayList[position]
        holder.hTitle.text=currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    //it will ask us how many item do we have in our project or recyclerview
    //iss app ka liya total newArrayList hoga sirf full item


   //how many list item are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    //it holds the view so views are not created ,so memory can be saved
    class MyViewHolder(itemView: View,Listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
       val hTitle=itemView.findViewById<TextView>(R.id.headingTitle)
       val hImage=itemView.findViewById<ShapeableImageView>(R.id.headingImage)


//        Kotlin init
//The code inside the init block is the first to be executed when the class is instantiate
        //ya wala code sab sa phele execute hoga jab wow class call hoga tab ya code sab sa phele execute hoga
        init{
            itemView.setOnClickListener {
                Listener.onItemClick(adapterPosition)
            }
        }
    }

}