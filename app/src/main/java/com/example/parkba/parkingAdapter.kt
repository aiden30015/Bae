package com.example.parkba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ParkingAdapter(
    private val parkingSpaces: List<ParkingSpace>,
    private val onItemClick: (ParkingSpace) -> Unit
) : RecyclerView.Adapter<ParkingAdapter.ParkingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parking_space_item, parent, false)
        return ParkingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkingViewHolder, position: Int) {
        val parkingSpace = parkingSpaces[position]
        holder.bind(parkingSpace)
    }

    override fun getItemCount() = parkingSpaces.size

    inner class ParkingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.space_number)
        private val statusTextView: TextView = itemView.findViewById(R.id.space_status)

        init {
            itemView.setOnClickListener {
                onItemClick(parkingSpaces[adapterPosition])
            }
        }

        fun bind(parkingSpace: ParkingSpace) {
            numberTextView.text = parkingSpace.number
            statusTextView.text = parkingSpace.status
        }
    }
}
