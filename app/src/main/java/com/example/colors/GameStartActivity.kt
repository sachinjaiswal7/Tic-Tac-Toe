package com.example.colors

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameStartActivity : AppCompatActivity() {
   private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var playerOne: TextView
    private lateinit var playerTwo: TextView

    private var size: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_start_activity)
        one = findViewById(R.id.one_text)
        two = findViewById(R.id.two_text)
        three = findViewById(R.id.three_text)

        four = findViewById(R.id.four_text)
        five = findViewById(R.id.five_text)
        six = findViewById(R.id.six_text)
        seven = findViewById(R.id.seven_text)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine_text)
        playerOne = findViewById(R.id.playerOne_text)
        playerTwo = findViewById(R.id.playerTwo_text)
        one.setOnClickListener {
        help(one)
        }
            two.setOnClickListener {
              help(two)
            }
        three.setOnClickListener {
            help(three)
        }

        four.setOnClickListener {
           help(four)
        }
        five.setOnClickListener {
            help(five)
        }
        six.setOnClickListener {
            help(six)
        }
        seven.setOnClickListener {
            help(seven)
        }
        eight.setOnClickListener {
            help(eight)

        }
        nine.setOnClickListener {
            help(nine)
        }


        }
        private fun message(value: Int) {
            when {
                value==9 -> Toast.makeText(this,"It's a Draw",Toast.LENGTH_SHORT).show()
                value % 2 == 0 -> {
                    Toast.makeText(this, "Player One won the Game", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Player Two won the game", Toast.LENGTH_SHORT).show()
                }
            }
        }
        private fun check(s:String):Boolean {
           if(one.text.toString()==s&&two.text==s&&three.text ==s)return true
            if(four.text==s&&six.text==s&&five.text==s)return true
            if(seven.text==s&&eight.text==s&&nine.text==s)return true
            if(one.text==s&&four.text==s&&seven.text==s)return true
            if(two.text==s&&six.text==s&&eight.text==s)return true
            if(three.text==s&&five.text==s&&nine.text==s)return true
            if(one.text==s&&six.text==s&&nine.text==s)return true
            if(seven.text==s&&six.text==s&&three.text==s)return true
            return false
        }
    private fun clear(){
        one.text = ""
        two.text = ""
        three.text =""
        four.text = ""
        five.text = ""
        six.text = ""
        seven.text  = ""
        eight.text = ""
        nine.text = ""
        playerOne.visibility = View.VISIBLE
        playerTwo.visibility = View.GONE
        size = 0




    }
    private fun help(box:TextView){
        if(box.text.isEmpty()) {
            if (size % 2 == 0) {
                box.text = "X"

                if (check(box.text.toString())) {
                    message(size)
                    clear()
                    return
                }
                size++
            }
            else{
                box.text = "O"

                if(check(box.text.toString())){
                    message(size)
                    clear()
                    return
                }

                size++
            }
            if(size==9){
                message(size)
                clear()
            }
            if(size%2==0){
                playerTwo.visibility = View.GONE
                playerOne.visibility = View.VISIBLE

            }
            else{
                playerOne.visibility = View.GONE
                playerTwo.visibility = View.VISIBLE
            }
        }
    }



}