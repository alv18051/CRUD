package com.javier.myapplication
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class ElementosAdaptador(private val listener: ElementosHolder.ClickListener):
    RecyclerView.Adapter<ElementosAdaptador.ElementosHolder>() {
    private var elementos: MutableList<elementos> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementosHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_elemento, parent, false)
        return ElementosHolder(view)
    }

    override fun onBindViewHolder(holder: ElementosHolder, position: Int) {
        holder.bind(elementos[position], listener)
    }

    override fun getItemCount(): Int {
        return this.elementos.size
    }

    fun addItem(aux: elementos) {
        this.elementos.add(aux)
        notifyItemInserted(itemCount)
    }

    fun removeItem(position: Int) {
        this.elementos.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItem(position: Int, aux: elementos) {
        this.elementos[position] = aux
        notifyItemChanged(position)
    }


    class ElementosHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(elementos: elementos, listener: ClickListener) = with(itemView){
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            val txtDescripcion: TextView = findViewById(R.id.txtDescripcion)


            txtTitulo.text = elementos.titulo
            txtDescripcion.text = elementos.descipcion


            setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }

            setOnLongClickListener {
                listener.onItemLongClicked(adapterPosition)
            }
        }
        interface ClickListener{
            fun onItemClicked(position: Int)
            fun onItemLongClicked(position: Int): Boolean
        }
    }
}