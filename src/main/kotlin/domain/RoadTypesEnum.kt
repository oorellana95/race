package domain

enum class RoadTypesEnum(val type: String, val adherence: Int) {
    ROAD("ROAD", 1),
    GROUND("GROUND", 2),
    WATER("WATER", 3),
    SNOW("SNOW", 4)
}