package com.boaz.foodapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// This is an Adapter that Creates The data to Put in Our Recycler View.
class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // Array of Food titles    
    private val titles = arrayOf(
        "Spaghetti",
        "Pizza",
        "Burger",
        "Indian Food",
        "Chilled Chips",
        "Pasta",
        "Chinese",
        "Chapati",
        "Chicken Chilled",
        "Cake")
    // Array of Food Details  
    private val details = arrayOf(
        "A long, thin, cylindrical pasta made from wheat flour and water. Traditionally served with a variety of sauces, such as marinara, pesto, or Alfredo, it can also be topped with vegetables, meatballs, or cheese.",
        "A savory dish from Italy, consisting of a typically round, flat base of leavened wheat-based dough topped with tomatoes, cheese, and various other ingredients. Popular toppings include pepperoni, mushrooms, and bell peppers. It’s baked at high temperatures, traditionally in a wood-fired oven.",
        "A sandwich consisting of a cooked patty of ground meat (often beef) placed inside a sliced bun. Burgers can be topped with various ingredients, including lettuce, tomato, onion, pickles, cheese, and sauces like ketchup or mayonnaise. Vegetarian and vegan versions are also popular.",
        "Indian cuisine is characterized by its wide variety of regional and traditional dishes, often featuring spices like cumin, coriander, turmeric, and chili. Common dishes include curry, biryani, dosa, and various bread like naan and roti. Vegetarian options are prevalent, reflecting cultural and religious dietary practices.",
        "Often referring to chilled potato chips (or fries), these are cooked potato slices or strips that are cooled, sometimes seasoned, and served as a snack or side dish. They can be enjoyed with dips or sauces.",
        "An Italian staple made from durum wheat semolina and water, pasta comes in various shapes and sizes, such as penne, fusilli, and linguine. It can be served with a variety of sauces, in salads, or baked in dishes like lasagna.",
        "Chinese cuisine includes a vast range of regional dishes, often characterized by the use of ingredients like rice, noodles, soy sauce, and a variety of vegetables and meats. Popular dishes include fried rice, dumplings, and stir-fries.",
        "A type of unleavened flatbread originating from the Indian subcontinent, chapati is made from whole wheat flour and water, rolled into thin circles and cooked on a hot griddle. It’s often served with curries or vegetables.",
        "This likely refers to chilled chicken dishes, which can include cooked chicken served cold, often in salads or as part of a platter. Commonly seasoned or marinated, these dishes are refreshing and can be served with various sauces or dressings.",
        "A sweet baked dessert typically made from flour, sugar, eggs, and butter. Cakes can be flavored with various ingredients such as chocolate, vanilla, fruit, and nuts. They come in many forms, including layered cakes, sponge cakes, and pound cakes, and are often frosted or decorated for special occasions like birthdays and weddings. Cakes can be served plain or with toppings like whipped cream, fruit, or fondant.")
    // Array of Food costs
    private val cost = arrayOf(
        "KES 700 ",
        "KES 1500 ",
        "KES 1000 ",
        "KES 1200 ",
        "KES 300 ",
        "KES 700 ",
        "KES 1200 ",
        "KES 500 ",
        "KES 1500 ",
        "KES 900 ")

    // Array of Food images  
    private val images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,

    )

    // Access the Single item XML Layout
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singleitem, viewGroup, false)
        return ViewHolder(v)
    }
    
    //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView    
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var itemImage: ImageView
       var itemTitle: TextView
       var itemDetail: TextView
       var itemCost: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_description)
            itemCost = itemView.findViewById(R.id.item_cost)

        

        }
    }

    //Set Items from Arrays and Put/Bind them in respectives Views    
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemCost.text = cost[i]

        //Below to be Done At the End to demonstrate how to move to Next Page on Item Click
        viewHolder.itemView.setOnClickListener {

           val intent = Intent(context, SingleItemActivity::class.java)
          context.startActivity(intent)
      }
    }

    // Get how many items the array have, All arrays must have equal sizes
    override fun getItemCount(): Int {
        return titles.size
    }
}
