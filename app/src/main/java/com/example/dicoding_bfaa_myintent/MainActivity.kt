package com.example.dicoding_bfaa_myintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnMoveActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_moveActivity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_moveActivity_data)

//        btnMoveActivity.setOnClickListener {
//            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
//            startActivity(moveIntent)
//        }

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_moveActivity -> {
            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(moveIntent)
            }
            R.id.btn_moveActivity_data -> {
                val moveData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Asep Sutisna")
                moveData.putExtra(MoveWithDataActivity.EXTRA_AGE, 19)
                startActivity(moveData)
            }
        }
    }
}