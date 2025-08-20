package com.example.acl

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCodigo = findViewById<EditText>(R.id.editCodigo)
        val btnCarregarCodigo = findViewById<Button>(R.id.btnCarregarCodigo)
        val btnAleatorio = findViewById<Button>(R.id.btnAleatorio)
        val imagemPrincipal = findViewById<ImageView>(R.id.idImage)

        btnCarregarCodigo.setOnClickListener {
            val codigo = editCodigo.text.toString()
            if (codigo.isNotEmpty()) {
                loadCat(codigo.toInt(), imagemPrincipal)
            } else {
                Toast.makeText(this, "Digite um código válido", Toast.LENGTH_SHORT).show()
            }
        }

        btnAleatorio.setOnClickListener {
            val codigos = listOf(100, 101, 200, 201, 202, 204, 301, 302, 400, 401, 403, 404, 418, 500, 502, 503)
            val codigoAleatorio = codigos.random()
            loadCat(codigoAleatorio, imagemPrincipal)
        }
    }

    private fun loadCat(code: Int, targetImageView: ImageView) {
        val imageUrl = "https://http.cat/$code.jpg"

        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.loading_image) // Imagem de carregamento
            .error(R.drawable.error_image)         // Imagem de erro
            .into(targetImageView, object : Callback {
                override fun onSuccess() {
                    Log.d("Picasso", "Imagem carregada com sucesso")
                }

                override fun onError(e: Exception?) {
                    Toast.makeText(this@MainActivity, "Erro ao carregar imagem", Toast.LENGTH_SHORT).show()
                }
            })
    }
}