package model.storage.mysql

object Constraints {
    const val MAX_NOTES_LENGTH = 150
    const val MAX_ARTIST_NAME_LENGTH = 32
    const val MAX_NATIONALITY_LENGTH = 32
    const val MAX_LOCATION_NAME = 150
    const val MAX_IMAGE_SOURCE_LENGTH = 150
    const val MAX_IMAGE_FILENAME_LENGTH = 32
}


object Table {
    const val CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS User (ID CHAR(36), PRIMARY KEY(ID));"
    const val CREATE_PIECE_TABLE = "CREATE TABLE IF NOT EXISTS Piece (ID CHAR(36), UserID CHAR(36), " +
            "ArtistID CHAR(36), Genre INT, Created DATE, Viewed DATE, CreatedLocID CHAR(36), ViewedLocID CHAR(36), " +
            "Notes VARCHAR(" + Constraints.MAX_NOTES_LENGTH + "), PRIMARY KEY(ID,UserID));"
    const val CREATE_ARTIST_TABLE = "CREATE TABLE IF NOT EXISTS Artist (ID CHAR(36), Name VARCHAR(" +
            Constraints.MAX_ARTIST_NAME_LENGTH + "), DOB Date, DOD Date, Nationality VARCHAR(" +
            Constraints.MAX_NATIONALITY_LENGTH + "), Genre INT, IsAlive BIT, PRIMARY KEY(ID));"
    const val CREATE_LOC_TABLE = "CREATE TABLE IF NOT EXISTS Location (ID CHAR(36), Name VARCHAR(" +
            Constraints.MAX_LOCATION_NAME + "), Lat DOUBLE PRECISION, Lon DOUBLE PRECISION, PRIMARY KEY(ID));"
    const val CREATE_IMAGE_TABLE = "CREATE TABLE IF NOT EXISTS Image (PieceID CHAR(36), Source VARCHAR(" +
            Constraints.MAX_IMAGE_SOURCE_LENGTH + "), Filename VARCHAR(" +
            Constraints.MAX_IMAGE_FILENAME_LENGTH + "), Bytes MEDIUMBLOB, PRIMARY KEY(PieceID,Source));"

    const val DROP_USER_TABLE = "DROP TABLE User;"
    const val DROP_PIECE_TABLE = "DROP TABLE Piece;"
    const val DROP_ARTIST_TABLE = "DROP TABLE Artist;"
    const val DROP_LOC_TABLE = "DROP TABLE Location;"
    const val DROP_IMAGE_TABLE = "DROP TABLE Image;"
}

object Queries {
    const val GET_USER = "SELECT * FROM User WHERE ID = ?;"

    const val GET_PIECE = "SELECT * FROM Piece WHERE ID = ?;"
    const val GET_USER_PIECES = "SELECT * FROM Piece WHERE UserID = ?;"
    const val GET_PIECES_BY_ARTIST = "SELECT * FROM Piece WHERE ArtistID = ?;"
    const val GET_PIECES_BY_ARTIST_NATIONALITY = "SELECT * FROM Piece " +
            "INNER JOIN Artist ON Artist.ID = Piece.ArtistID " +
            "WHERE Artist.Nationality = ?;"
    const val GET_PIECES_BY_GENRE = "SELECT * FROM Piece WHERE Genre = ?;"
    const val GET_SORTED_PIECES_CREATED_DATE = "SELECT * FROM Piece ORDER BY Created ASC;"
    const val GET_SORTED_PIECES_VIEWED_DATE = "SELECT * FROM Piece ORDER BY Viewed ASC;"
    const val GET_PIECES_BY_VIEWED_LOCATION_NAME = "SELECT * FROM Piece " +
            "INNER JOIN Location ON Location.ID = Piece.ViewedLocID " +
            "WHERE Location.Name = ?;"

    const val GET_ARTIST = "SELECT * FROM Artist WHERE ID = ?;"
    const val GET_ARTIST_BY_NAME = "SELECT * FROM Artist WHERE Name = ?;"
    const val GET_SORTED_ARTISTS_BY_NAME = "SELECT * FROM Artist ORDER BY Name ASC;"
    const val GET_SORTED_ARTISTS_BY_AGE = "SELECT * FROM Artist ORDER BY DOB DESC;"
    const val GET_ARTISTS_BY_NATIONALITY = "SELECT * FROM Artist ORDER BY Nationality ASC;"
    const val GET_ARTISTS_BY_GENRE = "SELECT * FROM Artist ORDER BY Genre ASC;"

    const val GET_LOC_NAME = "SELECT Name FROM Location WHERE ID = ?;"

    const val GET_PIECE_IMAGE = "SELECT * FROM Image WHERE PieceID = ? AND Source = ?;"
}

object Mutations {
    const val ADD_USER = "INSERT INTO User (ID) VALUES (?);"
    const val REMOVE_USER = "DELETE FROM User WHERE ID = ?;"

    const val ADD_PIECE = "INSERT INTO Piece (ID,UserID,ArtistID,Genre,Created,Viewed,CreatedLocID,ViewedLocID,Notes)" +
            " VALUES (?,?,?,?,?,?,?,?,?);"
    const val REMOVE_PIECE = "DELETE FROM Piece WHERE ID = ?;"
    const val UPDATE_PIECE_NOTES = "UPDATE Piece SET Notes = ? WHERE ID = ?;"

    const val ADD_ARTIST = "INSERT INTO Artist (ID,Name,DOB,DOD,Nationality,Genre,IsAlive) VALUES (?,?,?,?,?,?,?);"
    const val REMOVE_ARTIST = "DELETE FROM Artist WHERE ID = ?;"

    const val ADD_LOC = "INSERT INTO Location (ID,Name,Lat,Lon) VALUES (?,?,?,?);"
    const val REMOVE_LOC = "DELETE FROM Location WHERE ID = ?;"

    const val ADD_IMAGE = "INSERT INTO Image (PieceID,Source,Filename,Bytes) VALUES (?,?,?,?);"
    const val REMOVE_IMAGE = "DELETE FROM Image WHERE PieceID = ? AND Source = ?;"
}