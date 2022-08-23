package domain.car.models

import domain.car.parts.Engine
import domain.RoadTypesEnum
import domain.car.parts.Tank
import domain.car.parts.WheelsEnum
import domain.car.Car

class RobustCar(
    brand: String,
    model: String,
    wheels: WheelsEnum,
    engine: Engine,
    tank: Tank,
    weight: Double,
    odometer: Double = 0.0,
) : Car(
    brand,
    model,
    wheels,
    engine,
    tank,
    weight,
    odometer
) {
    override fun consumption(resistance: Double) {
        tank!!.currentLevel -= engine.benchmarkConsumption!! * resistance / 40
    }

    override fun advance(resistance: Double) {
        odometer += engine.horsepower / 12 - resistance
    }

    override fun needsToBrake(roadType: RoadTypesEnum): Boolean {
        if (roadType in wheels.roadTypes) {
            return false
        }
        return (1..10).random() == 10
    }
}