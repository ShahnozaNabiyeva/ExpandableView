package com.shahnoza.expandablelistview

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.shahnoza.expandablelistview.adapters.AdapterExpandable
import com.shahnoza.expandablelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapterExpandable: AdapterExpandable
    lateinit var list:ArrayList<String>
    lateinit var map:HashMap<String,List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list=ArrayList()
        map=HashMap()
        dateUploading()

        adapterExpandable=AdapterExpandable(list,map)
        binding.expandableListView.setAdapter(adapterExpandable)

    }

    private fun dateUploading() {
        list.add("Guruh 1")
        list.add("Guruh 2")
        list.add("Guruh 3")

        map[list[0]] = arrayListOf("Shahnoza","Malohat","Gavhariy")
        map[list[1]] = arrayListOf("Nigora","Shahlo")
        map[list[2]] = arrayListOf("Mubina","Iroda","Ifora","Imrona")

    }
}