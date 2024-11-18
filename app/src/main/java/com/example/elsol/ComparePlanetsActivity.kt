package com.example.elsol

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComparePlanetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compare_planets)

        val planetsData = mapOf(
            "Mercurio" to PlanetData(0.382, 0.387, 5400),
            "Venus" to PlanetData(0.949, 0.723, 5250),
            "Tierra" to PlanetData(1.0, 1.0, 5520),
            "Marte" to PlanetData(0.53, 1.542, 3960),
            "Júpiter" to PlanetData(11.2, 5.203, 1350),
            "Saturno" to PlanetData(9.41, 9.539, 700),
            "Urano" to PlanetData(3.38, 19.81, 1200),
            "Neptuno" to PlanetData(3.81, 30.07, 1500),
            "Plutón" to PlanetData(null, 39.44, null)
        )

        val planets = planetsData.keys.toList()

        val planetOneAutoComplete = findViewById<AutoCompleteTextView>(R.id.planetOneAutoComplete)
        val planetTwoAutoComplete = findViewById<AutoCompleteTextView>(R.id.planetTwoAutoComplete)

        val diameterPlanetOne = findViewById<TextView>(R.id.diameterPlanetOne)
        val diameterPlanetTwo = findViewById<TextView>(R.id.diameterPlanetTwo)
        val distancePlanetOne = findViewById<TextView>(R.id.distancePlanetOne)
        val distancePlanetTwo = findViewById<TextView>(R.id.distancePlanetTwo)
        val densityPlanetOne = findViewById<TextView>(R.id.densityPlanetOne)
        val densityPlanetTwo = findViewById<TextView>(R.id.densityPlanetTwo)

        // Configura el adaptador para los AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, planets)
        planetOneAutoComplete.setAdapter(adapter)
        planetTwoAutoComplete.setAdapter(adapter)

        // Manejar la selección de planetas
        fun updateTable() {
            val planetOne = planetOneAutoComplete.text.toString()
            val planetTwo = planetTwoAutoComplete.text.toString()

            val dataOne = planetsData[planetOne]
            val dataTwo = planetsData[planetTwo]

            dataOne?.let {
                diameterPlanetOne.text = it.diameter?.toString() ?: "???"
                distancePlanetOne.text = it.distanceToSun.toString()
                densityPlanetOne.text = it.density?.toString() ?: "???"
            }

            dataTwo?.let {
                diameterPlanetTwo.text = it.diameter?.toString() ?: "???"
                distancePlanetTwo.text = it.distanceToSun.toString()
                densityPlanetTwo.text = it.density?.toString() ?: "???"
            }
        }

        planetOneAutoComplete.setOnItemClickListener { _, _, _, _ -> updateTable() }
        planetTwoAutoComplete.setOnItemClickListener { _, _, _, _ -> updateTable() }
    }

    data class PlanetData(
        val diameter: Double?,
        val distanceToSun: Double,
        val density: Int?
    )
}
