package controller.api.rest

import java.util.UUID

class Manager {
    var sessionToUser: MutableMap<String, UUID> = mutableMapOf()

    fun beginSession(sessionID: String, userID: UUID) {
        sessionToUser.put(sessionID, userID)
    }

    fun endSession(sessionID: String) {
        sessionToUser.remove(sessionID)
    }

    fun validateTask(sessionID: String): Boolean {
        return sessionToUser[sessionID] != null
    }
}