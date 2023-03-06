package com.dicoding.tugasbasicandroid.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.tugasbasicandroid.R
import com.dicoding.tugasbasicandroid.data.Artikel

class ArtikelAdapter(private val listArtikel: ArrayList<Artikel>) :
    RecyclerView.Adapter<ArtikelAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.artikel_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listArtikel.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listArtikel[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        val shortDescription: String = description.substring(0, 100)
        holder.tvDescription.text = "$shortDescription..."
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listArtikel[position]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Artikel)
    }

}