package com.example.recyclerview_home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_home.adapter.TextAdapter
import com.example.recyclerview_home.databinding.ActivityMainBinding
import com.example.recyclerview_home.databinding.ActivityProductBinding

class Product : AppCompatActivity() {

    private lateinit var binding: ActivityProductBinding

    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val headerArray = resources.getStringArray(R.array.text_header)
        val pictureArray = resources.obtainTypedArray(R.array.image_product)
        val ingredientsArray = resources.getStringArray(R.array.Ingredients_product)
        val procedureArray = resources.getStringArray(R.array.Procedure_product)

        val intent = intent
        val stringHeader = intent.getStringExtra(TextAdapter.message)

        for(i in headerArray.indices) {
            if (headerArray[i] == stringHeader) {
                binding.imageView.setImageResource(pictureArray.getResourceId(i, -1))
                binding.textViewIngredients.text = ingredientsArray[i]
                binding.textViewProcedure.text = procedureArray[i]
                break;
            }
        }
        pictureArray.recycle()
    }
}