package com.dicoding.tugasbasicandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    private lateinit var thumbnail: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        thumbnail = findViewById(R.id.thumbnail_detail)
        title = findViewById(R.id.title_detail)
        description = findViewById(R.id.deskripsi_detail)

        supportActionBar?.title = "Detail Artikel"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")
        val gambar = intent.getIntExtra("gambar", 0)

        title.text = judul
        description.text = deskripsi
        thumbnail.setImageResource(gambar)

        val button_original:Button = findViewById(R.id.btn_original)
        button_original.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://bit.ly/41OKs6o"));
            startActivity(intent);
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> { // menangani klik tombol back
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
