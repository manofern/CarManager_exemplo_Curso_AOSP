package com.manofern.carmanager.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.manofern.carmanager.R
import com.manofern.carmanager.controller.CarDataController
import com.manofern.carmanager.model.CarData
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var controller: CarDataController
    private lateinit var tvSpeed: TextView
    private lateinit var tvRpm: TextView
    private lateinit var btnHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        controller = CarDataController()
        tvSpeed = findViewById(R.id.tvSpeed)
        tvRpm = findViewById(R.id.tvRpm)
        btnHistory = findViewById(R.id.btnHistory)

        try {
            val car : CarData = controller.create(Date().time, 120, 80)
            Log.i("CarDataDB", "Timestamp: ${car.timestamp}")
            Log.i("CarDataDB", "Speed: ${car.getSpeed()}")
            Log.i("CarDataDB", "RPM: ${car.getRpm()}")

            tvSpeed.text = "${car.getSpeed()}"
            tvRpm.text = "${car.getRpm()}"

            btnHistory.setOnClickListener {
                startActivity(Intent(this, HistoryActivity::class.java))
                Log.i("CarDataButton", "Clicou")
            }

        } catch (e: IllegalArgumentException) {
            Log.i("CarData DB", "Ocorreu um erro: ${e.message}")
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show() // Joga uma notificao na tela
        }


    }
}
