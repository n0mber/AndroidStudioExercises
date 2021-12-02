package com.example.piirtaminen

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() , SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var mSensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SUORITTAVAA KOODIA

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


        //ASETA PIIRROS NÄKYMÄÄN
        findViewById<MyView>(R.id.myView).setXY(200f, 0f)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        // TYHJÄ
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        findViewById<TextView>(R.id.textSensor).text = "Sensor value is " + p0!!.values[0]
        /*if (p0 != null) {
            p0.values[0]
        }*/
    }

    override fun onResume() {
        super.onResume()
        mSensor?.also { light ->
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}