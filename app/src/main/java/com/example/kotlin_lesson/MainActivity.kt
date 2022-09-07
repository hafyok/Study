package com.example.kotlin_lesson

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    var adapter: MyAdapter? = null
    var nav_view: NavigationView? = null
    //var rcView: RecyclerView? = null
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view = findViewById(R.id.nav_view)
        nav_view?.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArras(resources.getStringArray(R.array.fish),
        resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list, this)
        rcView?.adapter = adapter
    }

    //Работает именно для элементов меню. Если использовать просто слушатель, будет
    //отзываться на все элементы одинаково
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_fish -> {
                Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content), getImageId(R.array.fish_image_array)) )
            }
            R.id.id_na -> {
                Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content), getImageId(R.array.na_image_array)) )
            }
            R.id.id_sna -> Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "Id history haha", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun fillArras(titleArray:Array<String>, contentArray:Array<String>, imageArray:IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1){
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }


}