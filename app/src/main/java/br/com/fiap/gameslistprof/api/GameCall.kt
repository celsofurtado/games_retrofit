package br.com.fiap.gameslistprof.api

import br.com.fiap.gameslistprof.model.Game
import retrofit2.Call
import retrofit2.http.*

interface GameCall {

    @GET("games")
    fun getGames(): Call<List<Game>>

    @GET("games/{id}")
    fun getGameById(@Path("id") id: Long): Call<Game>

    @POST("games")
    fun saveGame(@Body game: Game): Call<Game>

}