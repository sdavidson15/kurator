package controller.api.rest

@RestController
class UploadPieceController {
    @GetMapping(RestRoutes.UPLOAD_PIECE_IMAGE)
    fun uploadPiece(@RequestParam(value = "sessionID") sessionID: String) {
        var manager = Manager()
        if (!manager.validateTask(sessionID)) {
            // error
        }
    }
}