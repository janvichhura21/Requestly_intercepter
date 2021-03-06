package com.example.requestly_intercepter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.requestly_intercepter.model.MainModel
import kotlinx.android.synthetic.main.adapter_movie.view.*


class MovieAdapter (var results: ArrayList<MainModel.Result>, val listener: OnAdapterListener):
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_movie,
                parent, false
            )
        )

        override fun getItemCount() = results.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val result = results[position]
            holder.view.textView.text = result.title
            Glide.with(holder.view)
                .load(result.image)
                .centerCrop()
                .into(holder.view.imageView)
            holder.view.setOnClickListener { listener.onClick(result) }
        }

        class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

        fun setData(data: List<MainModel.Result>) {
            this.results.clear()
            this.results.addAll(data)
            notifyDataSetChanged()
        }

        interface OnAdapterListener {
            fun onClick(result: MainModel.Result)
        }
    }
