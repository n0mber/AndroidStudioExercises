package com.example.tehtava1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainSettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_settings2)

        val s = intent.getStringExtra("avain")
        findViewById<EditText>(R.id.editTextPituus).setText(s)

        findViewById<Button>(R.id.buttonOK).setOnClickListener{
            finish()
        }
    }



    override fun finish() {
        var value = findViewById<EditText>(R.id.editTextPituus).text.toString()
        var s = value.toInt()
        setResult(s)
        super.finish()
    }
}