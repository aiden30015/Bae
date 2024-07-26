package com.example.parkba

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ParkingDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        val spaceNumber = intent.getStringExtra("spaceNumber")
        val status = intent.getStringExtra("status")
        val description = intent.getStringExtra("description")

        val spaceNumberView: TextView = findViewById(R.id.space_number)
        val statusView: TextView = findViewById(R.id.status)
        val descriptionView: TextView = findViewById(R.id.description)
        val carInfoView: TextView = findViewById(R.id.car_info)

        spaceNumberView.text = spaceNumber
        statusView.text = status
        descriptionView.text = description

        if (status == "사용 중") {
            val car = Car("Toyota", "Camry", "123-ABC") // 샘플 자동차 데이터
            carInfoView.text = "제조사: ${car.make}\n모델: ${car.model}\n번호판: ${car.licensePlate}"
        } else {
            carInfoView.text = "자동차 정보가 없습니다."
        }
    }
}
