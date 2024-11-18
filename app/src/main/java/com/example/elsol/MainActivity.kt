package com.example.elsol

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // Configurar Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Lista de imágenes solares
        val solarItems = listOf(
            SolarItem(R.drawable.coronasolar, "Corona solar"),
            SolarItem(R.drawable.erupcionsolar, "Erupcion solar"),
            SolarItem(R.drawable.espiculas, "Espiculas"),
            SolarItem(R.drawable.filamentos, "Filamentos"),
            SolarItem(R.drawable.magnetosfera, "Magnetosfera"),
            SolarItem(R.drawable.manchasolar, "Mancha solar"),

            )

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = SolarAdapter(solarItems)
    }

    // Inflar el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_compare_planets -> {
                // Mostrar mensaje de confirmación y navegar a la actividad
                Toast.makeText(this, "Cargando comparación de planetas...", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, ComparePlanetsActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}