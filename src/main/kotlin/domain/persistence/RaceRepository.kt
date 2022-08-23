package domain.persistence

interface RaceRepository {
    fun saveRace(raceData: List<String>)
}