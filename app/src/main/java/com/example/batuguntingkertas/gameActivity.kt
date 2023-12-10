package com.example.batuguntingkertas

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class gameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)

    }
    private fun  initListeners(){
        rockImageButton.setOnClickListener { startGame(option = "ROCK") }
        paperImageButton.setOnClickListener { startGame ( option =  "PAPER") }
        scissorsImageButton.setOnClickListener { startGame ( option =  "SCISSCORS") }

    }
    private fun startGame (option: String){
        val computerOption = game.pickRandomOption()
        computerImageView.setImageResource(game.pickDrawable(computerOption))

        when{
            game.isDraw(option,computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            game.isWin(option,computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

    }

}