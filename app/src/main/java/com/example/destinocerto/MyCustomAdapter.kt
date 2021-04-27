package com.example.destinocerto

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyCustomAdapter(val arrayList: ArrayList<Model>, val ctx: Context) :
RecyclerView.Adapter<MyCustomAdapter.ViewHolder>() {

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItaems(model: Model) {
        itemView.nameTv.text = model.CountryName
        itemView.descriptionTv.text = model.CountryDescription
        itemView.imageIv.setImageResource(model.CountryImage)
    }
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

    return ViewHolder(v)
}

override fun getItemCount(): Int {
    return arrayList.size
}

override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bindItaems(arrayList[position])

    holder.itemView.setOnClickListener {

        val model = arrayList.get(position)

        val gName : String = model.CountryName
        val gDescription : String = model.CountryDescription
        val gImageView : Int = model.CountryImage

        val intent = Intent(ctx, CountryImages::class.java)

        intent.putExtra("iName", gName)
        intent.putExtra("iDescription", gDescription)
        intent.putExtra("iImageView", gImageView)

        ctx.startActivity(intent)
        }
    }
}
