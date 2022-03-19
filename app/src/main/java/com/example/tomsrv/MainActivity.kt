package com.example.tomsrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
//  The recyclerView essenials
    class Litem (var Item_nbr:Int = 0, var interest: Intlvl = Intlvl.None, var descr:  String )
    internal var tblist = ArrayList<Litem>()
    enum class Intlvl {  None, Curious, Polite, Strong }
    lateinit var rvAdapter: RvAdapter
//  Standard program declarations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Minimal RecyclerView"
// The Recycleriew widget supporting decs
        val recyclerView: RecyclerView = findViewById(R.id.myrecyclerView)
        rvAdapter = RvAdapter(tblist)       // Names our custom Adapter and passes it our datalist
        val layoutManager = LinearLayoutManager(applicationContext) //Names or layout mgr and gives it our context
        recyclerView.layoutManager = layoutManager  // tells the rv widget to use the chosen layout mgr
        recyclerView.adapter = rvAdapter    // tells the rv widget the chosen adapter
//
//  Here we build the list of Objects to use in our RecyclerView.
        var temp: Litem         //First create a dummy object
        for ( i in 0..25 ) {    // Then instantiate a fresh (or "new") object of the Class each iteration
            temp = Litem(0,Intlvl.None,"Fun")
            temp.Item_nbr = i
// Un-comment one of the next two lines to suit
//            temp.interest = Intlvl.values()[i%4]  //Deterministic using index value.
            temp.interest = Intlvl.values()[(0..3).random()%4]  //random assignment.
            temp.descr = "This is item#"+i.toString()+"."
            tblist.add(temp)    // Add to the list
        }

 //       var j = 1             // Used to place debugging breakpoint
    }

}