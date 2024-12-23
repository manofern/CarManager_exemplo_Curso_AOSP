package com.manofern.carmanager.dao

import com.manofern.carmanager.model.CarData

interface Persistencia {

    fun create(model: CarData)
    fun delete(id: Int): Int
    fun update(model: CarData)
}