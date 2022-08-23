package domain.car

import domain.car.parts.Engine
import domain.RoadTypesEnum
import domain.car.parts.Tank
import domain.car.parts.WheelsEnum

open class Car(
    var brand: String,
    var model: String,
    var wheels: WheelsEnum,
    var engine: Engine,
    var tank: Tank?,
    var weight: Double,
    var odometer: Double = 0.0,
) {
    val isTankEmpty: Boolean
        get() = if (tank == null) {
            false
        } else {
        tank!!.currentLevel <= 0.0
    }

    fun reference(): String {
        return "$brand - $model"
    }

    fun forwardMovementBySecond(roadType: RoadTypesEnum) {
        val resistance = resistance(roadType = roadType)
        consumption(resistance)

        if (!needsToBrake(roadType = roadType))
            advance(resistance)
    }

    private fun resistance(roadType: RoadTypesEnum): Double {
        // Resistance depends on randomFactors, weight and the relation "wheels & roadType"
        var resistance = (2..4).random().toDouble()
        resistance += weight / 300

        resistance += if (roadType !in wheels.roadTypes) {
            (wheels.roadTypes.maxOrNull()?.adherence
                ?: throw Exception("Impossible to calculate wheels resistance, there is no data of adherence"))
        } else {
            1
        }

        return resistance
    }

    open fun consumption(resistance: Double) {
        if (tank == null) return
        tank!!.currentLevel -= engine.benchmarkConsumption!! * resistance / 40
    }

    open fun advance(resistance: Double) {
        odometer += engine.horsepower / 10 - resistance
    }

    open fun needsToBrake(roadType: RoadTypesEnum): Boolean {
        if (roadType in wheels.roadTypes) {
            return false
        }
        return (1..5).random() == 5
    }
}