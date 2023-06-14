package com.example.recyclerview_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_home.adapter.TextAdapter
import com.example.recyclerview_home.databinding.ActivityMainBinding
import com.example.recyclerview_home.model.TextInfo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TextAdapter
    private val textList: MutableList<TextInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val headerArray = resources.getStringArray(R.array.text_header)
        val textArray = resources.getStringArray(R.array.text_main)
        for (i in headerArray.indices){
            val textInfo = TextInfo(
                Header = headerArray[i],
                Text = textArray[i]
            )
            textList.add(textInfo)
        }

        val manager = LinearLayoutManager(this)
        adapter = TextAdapter(textList)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter
    }
}