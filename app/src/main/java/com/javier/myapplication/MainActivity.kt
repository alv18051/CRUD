package com.javier.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ElementosAdaptador.ElementosHolder.ClickListener {
    private val adapter = ElementosAdaptador(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd:Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val aux = elementos("Nuevo Elemento",
                "                                           presione para eliminarlo"
                )
            adapter.addItem(aux)
        }

        adapter.addItem(elementos("elemento 1",
            "                           presione para eliminarlo"

            ))
        adapter.addItem(elementos("elemento 2",
            "                           presione para eliminarlo"
            ))
        adapter.addItem(elementos("elemento 3",
            "                           presione para eliminarlo"
            ))



        val listaElemento: RecyclerView = findViewById(R.id.listaNoticias)
        listaElemento.layoutManager = LinearLayoutManager(this)
        listaElemento.adapter = adapter

    }
    override fun onItemClicked(position: Int) {
        adapter.removeItem(position)
    }
    override fun onItemLongClicked(position: Int): Boolean {
        val aux = elementos(
            "Actualizado",
            "Actualizado"

        )
        adapter.updateItem(position, aux)
        return true
    }
}