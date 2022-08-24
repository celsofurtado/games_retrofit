package br.com.fiap.gameslistprof.model

class Game {

    var id = 0
    var title = ""
    var studio = ""
    var description = ""
    var isFinished = false
    var releaseYear = 0

    override fun toString(): String {
        return "Game(id=$id, title='$title', studio='$studio', description='$description', isFinished=$isFinished, releaseYear=$releaseYear)"
    }


}