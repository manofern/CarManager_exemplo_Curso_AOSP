package com.manofern.carmanager.dao

import android.util.Log
import com.manofern.carmanager.model.CarData
import java.util.Date
import kotlin.math.log

class CarDataDAO : Persistencia {
    // Em Kotlin, em vez de usar List ou ArrayList,
    // utilizamos MutableList para indicar que a lista é mutável (ou seja, podemos adicionar,
    // remover ou modificar elementos).

    // A função mutableListOf() é usada para criar uma lista mutável.
    // A lista db é inicializada diretamente no corpo da classe.

    // Não é necessário usar um construtor como em Java,
    // já que em Kotlin o inicializador de propriedade é o suficiente para inicializar a lista.
    private val db: MutableList<CarData> = mutableListOf() // mock (banco de dados ficticio)

    override fun create(model: CarData) {
        db.add(model)
    }

    override fun delete(id: Int): Int {
        TODO("Not yet implemented")
    }

    override fun update(model: CarData) {
        TODO("Not yet implemented")
    }
}

//40min