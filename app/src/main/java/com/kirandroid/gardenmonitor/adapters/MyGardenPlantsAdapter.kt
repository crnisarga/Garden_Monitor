package com.kirandroid.gardenmonitor.adapters

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kirandroid.gardenmonitor.R
import com.kirandroid.gardenmonitor.models.PlantData


class MyGardenPlantsAdapter(private val context: Context, private val plantsList: ArrayList<PlantData>):
    RecyclerView.Adapter<MyGardenPlantsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.layout_my_garden_plant,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        // Showing Progress Indicator for loading Images
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.setColorFilter(0xf25645E, PorterDuff.Mode.SRC_ATOP)
        circularProgressDrawable.start()

        val requestOptions = RequestOptions()
        requestOptions.placeholder(circularProgressDrawable)
        requestOptions.error(R.drawable.icon)
        requestOptions.skipMemoryCache(true)
        requestOptions.fitCenter()

        Glide.with(context).load(plantsList.get(position).plantImageUrl)
            .apply(requestOptions)
            .into(holder.plantIcon)
        holder.plantDate.setText(plantsList.get(position).date)
        holder.plantName.setText(plantsList.get(position).plantScientificName)

        holder.plantName.isSelected = true

    }

    override fun getItemCount(): Int {
        return plantsList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val plantDate = itemView.findViewById<TextView>(R.id.plantDate)
        val plantIcon = itemView.findViewById<ImageView>(R.id.plantImage)
        val plantName = itemView.findViewById<TextView>(R.id.txtPlantName)
    }

}