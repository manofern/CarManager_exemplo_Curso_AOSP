package com.manofern.carmanager.model

data class CarData(
    var timestamp: Long = 0L,
    private var speed: Int = 0, // Propriedade privada
    private var rpm: Int = 0
) {
    // Função pública para obter o valor de speed
    fun getSpeed(): Int = speed

    // Função pública para definir o valor de speed
    fun setSpeed(newSpeed: Int) {
        if (newSpeed < 0) {
            throw IllegalArgumentException("Speed cannot be negative.") // Lança exceção
        }
        speed = newSpeed
    }

    fun getRpm(): Int = rpm

    fun setRpm(newRpm: Int) {
        if (newRpm < 0) {
            throw IllegalArgumentException("RPM cannot be negative.") // Lança exceção
        }
        rpm = newRpm
    }
}