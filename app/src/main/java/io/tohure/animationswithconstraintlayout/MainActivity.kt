package io.tohure.animationswithconstraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        btnFirst.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        btnSecond.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btnThird.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

    }
}
