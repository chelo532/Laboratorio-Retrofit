package com.example.clase4_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var noticias: Mutablelist<String> = mutablelistOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias.add("Prueba 1")
        noticias.add("Prueba 2")
        noticias.add("Prueba 3")
        noticias.add("Prueba 4")

        noticias.removeAt(0)
        noticias[0] = "Elemento"
        val listaNoticias =
    }
}