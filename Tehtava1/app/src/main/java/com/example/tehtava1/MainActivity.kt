package com.example.tehtava1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.tehtava1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //val navController = findNavController(R.id.nav_host_fragment_content_main)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<Button>(R.id.button).setOnClickListener {



            var tv = findViewById<TextView>(R.id.textView)


            var et1 = findViewById<EditText>(R.id.editTextNumber)
            var et2 = findViewById<EditText>(R.id.editTextNumber2)
            var teksti1 = et1.text.toString()
            var luku1 = teksti1.toFloat()
            var teksti2 = et2.text.toString()
            var luku2 = teksti2.toFloat()/100
            var ibm = luku1/(luku2*luku2)

            tv.text = ibm.toString()
        }

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            //avaa uusi activity
            var intent = Intent(this@MainActivity, MainSettings::class.java)
            var value = findViewById<EditText>(R.id.editTextNumber2)
            var s = value.text.toString()
            intent.putExtra("avain", s)
            //startActivity(intent)
            startActivityForResult(intent, 1)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        var result = resultCode.toString()
        findViewById<EditText>(R.id.editTextNumber2).setText(result)
        super.onActivityResult(requestCode, resultCode, data)
    }
}



