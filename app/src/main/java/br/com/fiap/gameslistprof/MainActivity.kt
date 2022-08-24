package br.com.fiap.gameslistprof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import br.com.fiap.gameslistprof.api.GameCall
import br.com.fiap.gameslistprof.api.RetrofitApi
import br.com.fiap.gameslistprof.model.Game
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var fbAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fbAdd = findViewById(R.id.fb_add)

        fbAdd.setOnClickListener {
            val intent = Intent(this, NewGameActivity::class.java)
            startActivity(intent)
        }

        //loadGames()
        loadGame()

    }

    fun loadGame() {

        var game = Game()
        val retrofit = RetrofitApi.getRetrofit()

        val gameCall = retrofit.create(GameCall::class.java)
        val call = gameCall.getGameById(2)

        call.enqueue(object : Callback<Game> {
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                game = response.body()!!
                Log.i("xpto", game.toString())
                Log.i("xpto", "rodou")
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                Log.i("xpto", "Erro: ${t.message}")
            }

        })

    }

    fun loadGames() {

        var games = listOf<Game>()

        val retrofit = RetrofitApi.getRetrofit()

        val gameCall = retrofit.create(GameCall::class.java)
        val call = gameCall.getGames()

        call.enqueue(object : Callback<List<Game>> {
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                games = response.body()!!
                Log.i("xpto", games.toString())
            }

            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                Log.i("xpto", "${t.cause}")
            }

        })

    }

}