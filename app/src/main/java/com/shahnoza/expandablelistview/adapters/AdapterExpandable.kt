package com.shahnoza.expandablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.shahnoza.expandablelistview.R


class AdapterExpandable(var title:List<String>,var map:HashMap<String,List<String>>) :BaseExpandableListAdapter(){
    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return map.get(title[groupPosition])!!.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return title.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        val key = title[groupPosition]
        val child = map[key]!!
        return child[groupPosition]

    }

    override fun getGroupId(groupPosition: Int): Long {
       return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
      return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
    return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {


        val itemView:View
        if (convertView==null){
            itemView=LayoutInflater.from(parent?.context).inflate(R.layout.item,parent,false)
        }else{
            itemView=convertView

        }
        itemView.findViewById<TextView>(R.id.item1_text).text=title[groupPosition]
        return itemView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {

        val itemView:View
        if (convertView==null){
            itemView=LayoutInflater.from(parent?.context).inflate(R.layout.item_child,parent,false)

        }else{
            itemView=convertView
        }
       val group=title.get(groupPosition)
        val child=map.get(group)!!
        val txt=child.get(childPosition)
        itemView.findViewById<TextView>(R.id.itemChildTextView).text=txt
        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {

        return true
    }
}