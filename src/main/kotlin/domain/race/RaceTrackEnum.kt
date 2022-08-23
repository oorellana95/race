package domain.race

import domain.RoadTypesEnum

enum class RaceTrackEnum(val reference: String, val city: String, val roadType: RoadTypesEnum, val kms: Int ) {
    CATALONIA("CAT0123", "BARCELONA", RoadTypesEnum.ROAD, 14),
    TRACKFORCE("NWY45", "OSLO", RoadTypesEnum.SNOW, 22),
    ROCCOS("ANTIOMEDELLIN", "MEDELLIN", RoadTypesEnum.GROUND, 18)
}