package com.example.nyamukmonitoring

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtill(
    private val oldList:List<item>,
    private val newList:List<item>
):DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].waktu == newList[newItemPosition].waktu
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].waktu != newList[newItemPosition].waktu ->{
                false
            }
            oldList[oldItemPosition].waktu != newList[newItemPosition].waktu ->{
                false
            }
            else -> true
        }
    }
}