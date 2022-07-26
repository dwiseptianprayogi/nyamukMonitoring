package com.example.nyamukmonitoring

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.core.RepoManager.clear
import java.util.Collections.addAll


class MyAdapter (private val fpList: ArrayList<item>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = fpList[position]

        holder.waktu.text = currentItem.waktu
        holder.status.text = currentItem.status
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val waktu = itemView.findViewById<TextView>(R.id.tvHistoryWaktuNyamuk)
        val status = itemView.findViewById<TextView>(R.id.tvHistoryStatusNyamuk)
    }

    override fun getItemCount(): Int {
        return fpList.size
    }

}