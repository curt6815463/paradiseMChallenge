package com.techapp.james.drawacard

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private val context: Context
    private val data: ArrayList<Item>

    private val layoutInflater: LayoutInflater

    constructor(context: Context, data: ArrayList<Item>) {
        this.context = context
        this.data = data
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemViewHolder
        var item = data[position]
        holder.cImageView.setImageResource(item.cImage)
        holder.bImageView.setImageResource(item.bImage)
        if (position == (data.size - 1)) {
            holder.bImageView.alpha = 0.7f
            Glide.with(context).load(R.drawable.mockbackground).into(holder.mImageView);
            holder.mImageView.alpha=0.7f
        }
    }

    class ItemViewHolder : RecyclerView.ViewHolder {
        var cImageView: ImageView
        var bImageView: ImageView
        var mImageView: ImageView

        constructor(itemView: View) : super(itemView) {
            cImageView = itemView.cImageView
            bImageView = itemView.bImageView
            mImageView = itemView.mockImageView
        }
    }

}
