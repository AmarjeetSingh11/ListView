package com.example.customlistviewproject2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

//iss ma adapter class banaya hai jiss ma doo parameter pass kar rha hai:-
// 1) first context pass kar rha hai
// 2) second hai data
// jo second wala hai wow iss ko extend kar rha hai


class MyAdapter(private val context:Activity, private val arrayList:ArrayList<User>):
    ArrayAdapter<User>(context,R.layout.eachitem,arrayList) {

    //iss ma bhi teen parameter lagta hai

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater=LayoutInflater.from(context)

        //iss ma hum view la rha hai eachitem wala ka

        val view=inflater.inflate(R.layout.eachitem,null)

        //uska baad image,name,lastmessage,lastmessagetime ka pata puuch rha hai hai

        val image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.tVName)
        val lastMsg=view.findViewById<TextView>(R.id.tVLastMessage)
        val lastMsgTime=view.findViewById<TextView>(R.id.tVLastMsgTime)

        //uska baad value daal di hai
        name.text=arrayList[position].name
        lastMsg.text=arrayList[position].lastMsg
        lastMsgTime.text=arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].ImgId)

        //or view ko return kardiya hai

        return view
    }

}