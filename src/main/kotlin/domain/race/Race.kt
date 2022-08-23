package domain.race

import domain.car.Car

class Race(
    val cars: List<Car>,
    val raceTrack: RaceTrackEnum,
    val laps: Int
) {
    private val totalKms = raceTrack.kms * laps
    private var raceData = mutableListOf<String>()

    fun start() {
        var areStillRacing = true
        val carsRacing = cars.toMutableList()

        while (areStillRacing) {
            raceData.add("")
            carsRacing.forEach {
                if (it.isTankEmpty) {
                    raceData.add("${it.reference()} is out of service.")
                    carsRacing.remove(it)
                } else {
                    it.forwardMovementBySecond(raceTrack.roadType)
                    raceData.add("${it.reference()} - Odometer: ${it.odometer}.")
                    if (it.odometer > totalKms) {
                        areStillRacing = false
                    }
                }
            }
        }
        val winner = carsRacing.maxByOrNull{ it.odometer }
        raceData.add("")
        raceData.add("WINNER: ${winner!!.reference()}")
    }

    fun printRaceData(){
        raceData.forEach{
            println(it)
        }
    }
}