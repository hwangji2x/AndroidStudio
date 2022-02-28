package com.example.lottotest

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random = Random()
    private val numbers = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<Button>(R.id.button1)
        val num2 = findViewById<Button>(R.id.button2)
        val num3 = findViewById<Button>(R.id.button3)
        val num4 = findViewById<Button>(R.id.button4)
        val num5 = findViewById<Button>(R.id.button5)
        val num6 = findViewById<Button>(R.id.button6)

        findViewById<FloatingActionButton>(R.id.runButton).setOnClickListener {
            numbers.clear()

            setLottoNum(num1)
            setLottoNum(num2)
            setLottoNum(num3)
            setLottoNum(num4)
            setLottoNum(num5)
            setLottoNum(num6)
        }
    }

    private fun setLottoNum(lottoNum: Button) {
        var num = 0
        while (true) {
            num = random.nextInt(45) + 1
            if ( !numbers.contains(num) ) {
                numbers.add(num)
                break
            }
        }

        lottoNum.text = "${num}"

        if ( num <= 10 ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(250,225,40))
        } else if (num <= 20) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,0,225))
        } else if (num <= 30) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(225,0,0))
        } else if (num <= 40 ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
        } else {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,225,0))
        }
    }
}