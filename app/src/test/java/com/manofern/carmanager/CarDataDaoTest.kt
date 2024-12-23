package com.manofern.carmanager

import android.util.Log
import com.manofern.carmanager.dao.CarDataDAO
import com.manofern.carmanager.model.CarData
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date


class CarDataDaoTest {

    @Test
    fun create(){
        try {
            val car = CarData()
            car.timestamp = Date().time
            car.setSpeed(120)
            car.setRpm(80)

            val dao = CarDataDAO()
            dao.create(car)

            assertEquals(120,car.getSpeed())
        } catch ( e: IllegalArgumentException) {
            Log.i("CarDataTest", "Ocorreu um erro: ${e.message}")
        }
    }

    @Test
    fun update(){

    }

    @Test
    fun delete(){

    }

}


