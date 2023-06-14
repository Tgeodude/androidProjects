package com.example.recyclerview_home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_home.Product
import com.example.recyclerview_home.databinding.ItemTextBinding
import com.example.recyclerview_home.model.TextInfo

class TextAdapter(textList: MutableList<TextInfo>) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    private val textListAdapter = textList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.TextViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTextBinding.inflate(inflater, parent, false)

        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextAdapter.TextViewHolder, position: Int) {
        val text = textListAdapter[position]
        val context = holder.itemView.context

        with(holder.binding) {
            textHeader.text = text.Header
            textMain.text = text.Text
        }
    }

    override fun getItemCount(): Int = textListAdapter.size


    class TextViewHolder(val binding: ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.textMain.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, Product::class.java)
                intent.putExtra(message, "${binding.textHeader.text}")
                context.startActivity(intent)
            }
            binding.textHeader.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, Product::class.java)
                intent.putExtra(message, "${binding.textHeader.text}")
                context.startActivity(intent)
            }
        }
    }

    companion object {
        const val message = "id"
    }

}