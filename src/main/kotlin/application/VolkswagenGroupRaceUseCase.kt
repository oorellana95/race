package application

import domain.car.parts.Engine
import domain.race.Race
import domain.race.RaceTrackEnum
import domain.car.parts.Tank
import domain.car.parts.WheelsEnum
import domain.car.Car
import domain.car.models.InfiniteFuelCar
import domain.car.models.RobustCar
import domain.car.models.SuperCar

class VolkswagenGroupRaceUseCase(
    //Persist in a File as JSON
    //private val finishedGoodRepository: FinishedGoodRepository
) {
    fun execute(): Unit {
        val race = Race(
            cars = cars(),
            raceTrack = RaceTrackEnum.CATALONIA,
            laps = 5
        )
        race.start()
        race.printRaceData()
    }


    private fun cars(): List<Car> {
        return listOf(
            Car(
                brand = "VOLKSWAGEN",
                model = "POLO",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 206.6, benchmarkConsumption = 7.3),
                tank = Tank(capacity = 700.0),
                weight = 1800.0
            ),
            Car(
                brand = "SEAT",
                model = "LEON",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 199.8, benchmarkConsumption = 7.3),
                tank = Tank(capacity = 700.0),
                weight = 1800.0
            ),
            RobustCar(
                brand = "CUPRA",
                model = "ATECA",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 260.6, benchmarkConsumption = 9.0),
                tank = Tank(capacity = 1000.0),
                weight = 2100.0
            ),
            Car(
                brand = "VOLKSWAGEN",
                model = "TIGUAN",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 211.3, benchmarkConsumption = 7.8),
                tank = Tank(capacity = 740.0),
                weight = 1800.0
            ),
            SuperCar(
                brand = "BUGATTI",
                model = "DIVO",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 275.2, benchmarkConsumption = 12.1),
                tank = Tank(capacity = 0.0),
                weight = 2000.0
            ),
            InfiniteFuelCar(
                brand = "BUGATTI",
                model = "DIVO-ELECTRIC",
                wheels = WheelsEnum.ALLOY,
                engine = Engine(horsepower = 275.2),
                weight = 2000.0
            )
        )
    }
}
