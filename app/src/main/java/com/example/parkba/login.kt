package com.example.parkba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Login : AppCompatActivity() {
    private val parkingSpaces = listOf(
        ParkingSpace("주차 공간 1", "사용 가능", ""),
        ParkingSpace("주차 공간 2", "사용 중", ""),
        ParkingSpace("주차 공간 3", "사용 가능", ""),
        ParkingSpace("주차 공간 4", "사용 중", ""),
        ParkingSpace("주차 공간 5", "사용 가능", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginui)
        supportActionBar?.hide()
        val parkingList: RecyclerView = findViewById(R.id.parking_list)
        parkingList.layoutManager = LinearLayoutManager(this)
        parkingList.adapter = ParkingAdapter(parkingSpaces) { parkingSpace ->
            val intent = Intent(this, ParkingDetailActivity::class.java).apply {
                putExtra("spaceNumber", parkingSpace.number)
                putExtra("status", parkingSpace.status)
                putExtra("description", parkingSpace.description)
            }
            startActivity(intent)
        }
    }
}
