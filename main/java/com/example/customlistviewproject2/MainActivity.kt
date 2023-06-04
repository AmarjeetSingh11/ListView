package com.example.customlistviewproject2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    //iss ma hama na user arraylist banya hai jika type user rakha hai

    lateinit var userArrayList:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // iss ma hamna sabka array banya hai jo sabki information contain kara ga

        val name= arrayOf("Rahul","Saumya","Prastuti","Ankit","Roshni")

        val lastMsg= arrayOf("Hey Everyone","I am Fine","Good","Enjoying the Coding Life","Software Engineer")

        val lastMsgTime= arrayOf("6:25 AM","1:00 AM","4:00 PM","7:00 PM","8:00 PM")

        val phoneNumber= arrayOf("8876965721","9706752642","9101371104","8402011219","8822348225")

        val imgId= intArrayOf(R.drawable.pic1,R.drawable.pic5,R.drawable.pic4,R.drawable.pic2,R.drawable.pic3)


        //intialize kiya lateinit var ko

        userArrayList=ArrayList()


        //ya code one by one data add kara ga issma
        for(eachIndex in name.indices){

            //value dal rha hai user ko traverse kar ka
            val user=User(name[eachIndex],lastMsg[eachIndex],lastMsgTime[eachIndex],phoneNumber[eachIndex],imgId[eachIndex])

            userArrayList.add(user)
        }

        //issma listview find kar rha hai hai

        val listView=findViewById<ListView>(R.id.listView)
        //iss ma listview ko clickable bana rha hai
        listView.isClickable=true

        //adapter set kara ga
        listView.adapter=MyAdapter(this,userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->

            //open kara ga new activity ya user class ka sara data ka kaam kiya hai
            val userName=name[position]
            val userPhone=phoneNumber[position]
            val imgId=imgId[position]

            val i= Intent(this,UserActivity::class.java)
            i.putExtra("name",userName)
            i.putExtra("Phone",userPhone)
            i.putExtra("ImageId",imgId)
            startActivity(i)
        }
    }
}