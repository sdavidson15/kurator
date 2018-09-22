package model

import java.time.Instant
import java.util.UUID

import kotlin.collections.MutableMap


class User(_uuid: UUID = UUID.randomUUID(), _pieces: MutableMap<UUID, Piece> = mutableMapOf()) {
    val uuid: UUID = _uuid
    var pieces: MutableMap<UUID, Piece> = _pieces
}

class Piece(_uuid: UUID = UUID.randomUUID(), _artist: Artist = Artist(), _createdDate: Instant = Instant.now(),
            _viewedDate: Instant = Instant.now(), _genre: Genre = Genre.Default, _createdLoc: Location = Location(),
            _viewedLoc: Location = Location(), _notes: String = "") {

    val uuid: UUID = _uuid
    val artist: Artist = _artist
    val genre: Genre = _genre
    val createdDate: Instant = _createdDate
    val viewedDate: Instant = _viewedDate
    val paintedLoc: Location = _createdLoc
    val viewedLoc: Location = _viewedLoc
    var notes: String = _notes
}

class Artist(_uuid: UUID = UUID.randomUUID(), _name: String = "", _dob: Instant = Instant.now(),
             _dod: Instant = Instant.now(), _nationality: String = "", _genre: Genre = Genre.Default,
             _isAlive: Boolean = false) {

    val uuid: UUID = _uuid
    val name: String = _name
    val dateOfBirth: Instant = _dob
    val dateOfDeath: Instant = _dod
    val nationality: String = _nationality
    val genre: Genre = _genre
    val isAlive: Boolean = _isAlive
}

class Location(_name: String = "", _lat: Double = 0.0, _lon: Double = 0.0) {
    val name: String = _name
    val lat: Double = _lat
    val lon: Double = _lon
}

enum class Genre {
    Default, Impressionism, Realism, PostImpressionism
}
