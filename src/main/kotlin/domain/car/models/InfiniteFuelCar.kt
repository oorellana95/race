package domain.car.models

import domain.car.parts.Engine
import domain.car.parts.Tank
import domain.car.parts.WheelsEnum
import domain.car.Car

class InfiniteFuelCar(
    brand: String,
    model: String,
    wheels: WheelsEnum,
    engine: Engine,
    weight: Double,
    odometer: Double = 0.0,
    tank: Tank? = null,
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
        return
    }

    override fun advance(resistance: Double) {
        odometer += engine.horsepower / 14 - resistance
    }
}