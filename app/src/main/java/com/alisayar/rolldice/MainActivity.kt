package com.alisayar.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.databinding.DataBindingUtil
import com.alisayar.rolldice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var playerOneScore: Int = 0
    private var playerTwoScore: Int = 0

    private var playerOneDice: Int = 0
    private var playerTwoDice: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {

            startButton.setOnClickListener {
                startButton.visibility = View.GONE
                diceOneImage.visibility = View.VISIBLE
                diceTwoImage.visibility = View.VISIBLE
                howToText.visibility = View.GONE
                howToPlayText.visibility = View.GONE
                playerOneButton.visibility = View.VISIBLE
                playerTwoButton.visibility = View.VISIBLE
                arrowBottom.visibility = View.VISIBLE
                refreshButton.visibility = View.VISIBLE
                playerOneButton.isClickable = true
                playerTwoButton.isClickable = false
            }

            playerOneButton.setOnClickListener {
                playerOneButton.isClickable = false
                playerTwoButton.isClickable = false
                rollDice(1)
            }
            playerTwoButton.setOnClickListener {
                playerOneButton.isClickable = false
                playerTwoButton.isClickable = false
                rollDice(2)
            }

            refreshButton.setOnClickListener {
                playerOneScore = 0
                playerTwoScore = 0
                val score = Score(playerOneScore = playerOneScore.toString(), playerTwoScore = playerTwoScore.toString())
                binding.score = score
                playerOneButton.isClickable = true
                playerTwoButton.isClickable = false
                arrowBottom.visibility = View.VISIBLE
                arrowTop.visibility = View.GONE
            }
        }


    }

    private fun rollDice(player: Int){   //  1 -> player one  2 -> player two

        object : CountDownTimer(1500, 50){
            override fun onTick(millisUntilFinished: Long) {
                val randomOne = (1..6).random()
                val randomTwo = (1..6).random()
                binding.apply {
                    when(randomOne){
                        1 -> diceOneImage.setImageResource(R.drawable.dice_1)
                        2 -> diceOneImage.setImageResource(R.drawable.dice_2)
                        3 -> diceOneImage.setImageResource(R.drawable.dice_3)
                        4 -> diceOneImage.setImageResource(R.drawable.dice_4)
                        5 -> diceOneImage.setImageResource(R.drawable.dice_5)
                        6 -> diceOneImage.setImageResource(R.drawable.dice_6)
                    }
                    when(randomTwo){
                        1 -> diceTwoImage.setImageResource(R.drawable.dice_1)
                        2 -> diceTwoImage.setImageResource(R.drawable.dice_2)
                        3 -> diceTwoImage.setImageResource(R.drawable.dice_3)
                        4 -> diceTwoImage.setImageResource(R.drawable.dice_4)
                        5 -> diceTwoImage.setImageResource(R.drawable.dice_5)
                        6 -> diceTwoImage.setImageResource(R.drawable.dice_6)
                    }
                }

            }

            override fun onFinish() {
                val randomOne = (1..6).random()
                val randomTwo = (1..6).random()
                binding.apply {
                    when(randomOne){
                        1 -> diceOneImage.setImageResource(R.drawable.dice_1)
                        2 -> diceOneImage.setImageResource(R.drawable.dice_2)
                        3 -> diceOneImage.setImageResource(R.drawable.dice_3)
                        4 -> diceOneImage.setImageResource(R.drawable.dice_4)
                        5 -> diceOneImage.setImageResource(R.drawable.dice_5)
                        6 -> diceOneImage.setImageResource(R.drawable.dice_6)
                    }
                    when(randomTwo){
                        1 -> diceTwoImage.setImageResource(R.drawable.dice_1)
                        2 -> diceTwoImage.setImageResource(R.drawable.dice_2)
                        3 -> diceTwoImage.setImageResource(R.drawable.dice_3)
                        4 -> diceTwoImage.setImageResource(R.drawable.dice_4)
                        5 -> diceTwoImage.setImageResource(R.drawable.dice_5)
                        6 -> diceTwoImage.setImageResource(R.drawable.dice_6)
                    }


                    if (player == 1){
                        playerOneDice = randomOne + randomTwo
                        playerTwoButton.isClickable = true
                        arrowBottom.visibility = View.GONE
                        arrowTop.visibility = View.VISIBLE
                    } else{
                        playerOneButton.isClickable = true
                        arrowBottom.visibility = View.VISIBLE
                        arrowTop.visibility = View.GONE
                        playerTwoDice = randomOne + randomTwo
                        if (playerTwoDice > playerOneDice) {
                            playerTwoScore++
                        } else if (playerOneDice > playerTwoDice){
                            playerOneScore++
                        }
                        val score = Score(playerOneScore.toString(), playerTwoScore.toString())
                        binding.score = score
                    }
                }
            }
        }.start()


    }
}