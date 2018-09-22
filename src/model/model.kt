package model

import java.time.Instant
import java.util.UUID

import kotlin.collections.MutableMap


class User(_uuid: UUID = UUID.randomUUID(), _pieces: MutableMap<UUID, Piece> = mutableMapOf()) {
    val uuid: UUID = _uuid
    var pieces: MutableMap<UUID, Piece> = _pieces
}

class Piece(_uuid: UUID = UUID.randomUUID(), _userID: UUID = UUID.randomUUID(), _artist: Artist = Artist(),
            _createdDate: Instant = Instant.now(), _viewedDate: Instant = Instant.now(), _genre: Genre = Genre.Default,
            _createdLoc: Location = Location(), _viewedLoc: Location = Location(), _origImg: Image = Image(),
            _loadedImg: Image = Image(), _notes: String = "") {

    val uuid: UUID = _uuid
    val userID: UUID = _userID
    val artist: Artist = _artist
    val genre: Genre = _genre
    val createdDate: Instant = _createdDate
    val viewedDate: Instant = _viewedDate
    val createdLoc: Location = _createdLoc
    val viewedLoc: Location = _viewedLoc
    val origImg: Image = _origImg
    val loadedImg: Image =_loadedImg
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

class Location(_uuid: UUID = UUID.randomUUID(), _name: String = "", _lat: Double = 0.0, _lon: Double = 0.0) {
    val uuid: UUID = _uuid
    val name: String = _name
    val lat: Double = _lat
    val lon: Double = _lon
}
class Image(_pieceID: UUID = UUID.randomUUID(), _source: String = "", _filename: String = "",
            _bytes: ByteArray = ByteArray(8192)) {

    val pieceID: UUID = _pieceID
    val source: String = _source
    val filename: String = _filename
    val bytes: ByteArray = _bytes
}

enum class Genre {
    Default, Impressionism, Realism, PostImpressionism
}
