package com.example.dicoding_bfaa_myintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnMoveActivity: Button
    lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi and Assignment
        btnMoveActivity = findViewById(R.id.btn_moveActivity)
        tvResult = findViewById(R.id.tv_result)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_moveActivity_data)
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)


//        btnMoveActivity.setOnClickListener {
//            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
//            startActivity(moveIntent)
//        }

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
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
                val dataPerson = Person(
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
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
//                startActivityForResult(moveForResultIntent, REQUEST_CODE)
                resultLauncher.launch(moveForResultIntent)

            }
        }
    }

    //nyoba fix 1
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE) {
            // There are no request codes
            val data: Intent? = result.data
            val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    /*
    // Original code with dicoding
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == REQUEST_CODE) {
                if (resultCode == MoveForResultActivity.RESULT_CODE) {
                    val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                    tvResult.text = "Hasil : $selectedValue"
                }
            }
       }
    */




}