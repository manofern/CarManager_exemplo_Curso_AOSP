package com.manofern.carmanager.controller

import com.manofern.carmanager.dao.CarDataDAO
import com.manofern.carmanager.model.CarData

class CarDataController(
     // Declara que dao é do tipo CarDataDAO, e "= CarDataDAO()" Atribui um valor inicial a dao.
     private var dao: CarDataDAO = CarDataDAO(),
     private var car: CarData = CarData()
) {
     // uma classe do tipo CarData
     fun create(timestamp: Long, speed: Int, rpm: Int): CarData {
          car.timestamp = timestamp
          try {
               car.setSpeed(speed) // Validação acontece aqui
          } catch (e: IllegalArgumentException) {
               //println("Error: ${e.message}")
               throw e // Relança a exceção para quem chamar lidar com ela
          }
          try {
               car.setRpm(rpm) // Validação acontece aqui
          } catch (e: IllegalArgumentException) {
               throw e
          }

          dao.create(car)

          return car
      }
}

