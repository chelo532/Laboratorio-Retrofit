//Marcelo Calderon, Laboratorio 4:  Retrofit 2

package com.example.lab4

import android.annotation.SuppressLint
import android.app.PendingIntent.getService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lab4.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//Clase Main
class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnSrch: Button = findViewById(R.id.btnSrch)
        val search: EditText = findViewById(R.id.Search)
        val vista: TextView = findViewById(R.id.vistaInfo)

        val num = "0123456789"

        btnSrch.setOnClickListener {
            run {

                val r2 = R2()

                val srch = search.text.toString().toLowerCase()

                if(search!!.text.any {it in num}) {
                    val toast = Toast.makeText(applicationContext, "No puede ingresar numeros", Toast.LENGTH_SHORT)
                    toast.show()
                    vista.text = ""
                }
                if (srch.length > 50) {
                    val toast = Toast.makeText(applicationContext, "No puede tener mas de 50 char", Toast.LENGTH_SHORT)
                    toast.show()
                    vista.text = ""
                }

                val call: Call<JsonObject> = r2.getService().getPokemonById(srch)

                call.enqueue(object : Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.isSuccessful){
                            val p1: JsonObject? = response.body()
                            val name1 = p1!!["name"].asString.capitalize()

                            assert(p1 != null)

                            var PKMn_DATA = ("\n Name: " + name1
                                    + "\n Height: ${p1!!["height"]}"
                                    + "\n Weight: ${p1!!["weight"]}"
                                    + "\n Starting EXP: ${p1!!["base_experience"]}")
                            vista.text = PKMn_DATA
                            Log.i("detalle", p1.toString())
                        } else{0
                            Log.e("error", "Hubo un error!")
                        }
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Log.e("error", t.toString())
                    }

                })

            }
        }

    }


}

