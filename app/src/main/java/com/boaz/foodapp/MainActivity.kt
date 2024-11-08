package com.boaz.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Fetch your recycler view by id
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

//        Define the layout Manager
//        the layout manager sets the recycler views appear in vertical format
        val layoutmanager = LinearLayoutManager(applicationContext)


//        put the layout manager inside the recycler to make items appear vertical
        recyclerView.layoutManager = layoutmanager

//        Get an instance of Recycler Adapter
//        The recycler Adapter contains all the arrays
//        The Arrays include images, titles, description amd costs.

        val adapter  = RecyclerAdapter(applicationContext)

//        Load the data to the recycler view
        recyclerView.adapter = adapter

//        Find the bottom sheet by id
        val bottomsheet = findViewById<FrameLayout>(R.id.bottomsheet)
        BottomSheetBehavior.from(bottomsheet).apply {
            peekHeight = 350
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

//        Fetch order now button
        val buttonorder = findViewById<Button>(R.id.ordernow)
        buttonorder.setOnClickListener {
            val intent = Intent(applicationContext, OrderActivity::class.java)
            startActivity(intent)
        }


    }

}