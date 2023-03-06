package com.dicoding.tugasbasicandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.tugasbasicandroid.adapter.ArtikelAdapter
import com.dicoding.tugasbasicandroid.data.Artikel

class MainActivity : AppCompatActivity() {
    private lateinit var rvArtikel: RecyclerView
    private val list = ArrayList<Artikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArtikel = findViewById(R.id.rvArtikel)
        rvArtikel.setHasFixedSize(true)
        list.addAll(getListsArtikel())
        showLists()
    }

    private fun showLists() {
        rvArtikel.layoutManager = LinearLayoutManager(this)
        val listArtikelAdapter = ArtikelAdapter(list)
        rvArtikel.adapter = listArtikelAdapter
    }

    @SuppressLint("Recycle")
    private fun getListsArtikel(): Collection<Artikel> {
        val dataName = resources.getStringArray(R.array.data_title)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_thumbnail)
        val listArtikel = ArrayList<Artikel>()
        for (i in dataName.indices) {
            val artikel = Artikel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listArtikel.add(artikel)
        }
        return listArtikel
    }
}