package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // Roll dice when starting the app
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val dice1Image: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on dice roll
        val drawableResource = when (diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        dice1Image.setImageResource(drawableResource)
        dice1Image.contentDescription = diceRoll.toString()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        val dice2Image: ImageView = findViewById(R.id.imageView2)
        val drawable = when (diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }

        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()

        dice2Image.setImageResource(drawable)

    }
}

class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */

    fun roll(): Int {
        return (1..numSides).random()
    }
}