package com.manofern.carmanager

import android.util.Log
import com.manofern.carmanager.model.CarData
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date

class CarDataTest {

    @Test
    fun createSet() {
        try {
            val obj = CarData()
            obj.timestamp = Date().time
            obj.setSpeed(120)
            obj.setRpm(80)

            assertEquals(120, obj.getSpeed())
        } catch (e: IllegalArgumentException) {
            Log.i("CarDataTest", "Ocorreu um erro: ${e.message}")
            Assert.fail()
        }
    }
}