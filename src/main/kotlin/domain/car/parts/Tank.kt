package domain.car.parts

data class Tank(
    val capacity: Double,
    var currentLevel: Double = capacity
)