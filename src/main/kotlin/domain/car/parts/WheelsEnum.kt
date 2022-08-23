package domain.car.parts

import domain.RoadTypesEnum

enum class WheelsEnum(val type: String, val roadTypes: List<RoadTypesEnum>) {
    ALLOY("ALLOY", listOf(RoadTypesEnum.ROAD, RoadTypesEnum.GROUND)),
    STEEL("STEEL", listOf(RoadTypesEnum.SNOW, RoadTypesEnum.WATER)),
    FORGED("FORGED", listOf(RoadTypesEnum.GROUND, RoadTypesEnum.WATER)),
    SPLIT("SPLIT", listOf(RoadTypesEnum.ROAD, RoadTypesEnum.WATER))
}