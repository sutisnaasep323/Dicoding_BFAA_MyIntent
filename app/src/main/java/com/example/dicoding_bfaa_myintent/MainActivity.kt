package com.example.dicoding_bfaa_myintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnMoveActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi and Assignment
        btnMoveActivity = findViewById(R.id.btn_moveActivity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_moveActivity_data)
        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)

//        btnMoveActivity.setOnClickListener {
//            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
//            startActivity(moveIntent)
//        }

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)

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
            R.id.btn_move_activity_object -> {
                val dataPerson = Person (
                    "Asep Sutisna",
                    19,
                    "sutisnaasep323@gmail.com",
                    "Bogor"
                        )

                val moveData = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveData.putExtra(MoveWithObjectActivity.EXTRA_PERSON, dataPerson)
                startActivity(moveData)
            }
            R.id.btn_dial_number -> {
                val myNumber = "081775205889"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$myNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}