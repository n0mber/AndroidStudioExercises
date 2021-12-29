package com.example.piirtaminen

import android.animation.ObjectAnimator
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
        findViewById<MyView>(R.id.myView).setXY(400f, 0f)
        /*ObjectAnimator.ofFloat(findViewById<MyView>(R.id.myView), "translationY", 1000f).apply {
            duration = 3000
            start()
        }*/


    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        // TYHJÄ
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        findViewById<TextView>(R.id.textSensor).text = "Sensor value is " + p0!!.values[0]
        /*if (p0 != null) {
            p0.values[0]
        }*/
        if (p0.values[0] >= 9){
            ObjectAnimator.ofFloat(findViewById<MyView>(R.id.myView), "translationX", -300f).apply {
                duration = 2000
                start()}
        }
        if (p0.values[0] <= -9){
            ObjectAnimator.ofFloat(findViewById<MyView>(R.id.myView), "translationX", 300f).apply {
                duration = 2000
                start()}
        }

        if (p0.values[0] >= 0 && p0.values[0] < 9  ){
            ObjectAnimator.ofFloat(findViewById<MyView>(R.id.myView), "translationY", 1000f).apply {
                duration = 2000
                start()}
        }

        if (p0.values[0] < 0 && p0.values[0] > -9  ){
            ObjectAnimator.ofFloat(findViewById<MyView>(R.id.myView), "translationY", 0f).apply {
                duration = 2000
                start()}
        }


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