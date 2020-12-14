import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_final.ClickListener
import com.example.proyecto_final.LongClickListener
import com.example.proyecto_final.R
import com.example.proyecto_final.Registro


class AdaptadorCustom(items:ArrayList<Registro>, var listener: ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {


    var items: ArrayList<Registro>? = null
    var multiSeleccion = false

    var itemsSeleccionados: ArrayList<Int>? = null
    var viewHolder: ViewHolder? = null

    init {
        this.items = items
        itemsSeleccionados = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.emplate_registro, parent, false)
        viewHolder = ViewHolder(vista, listener, longClickListener)

        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)
        holder.Id?.text = item?.Id
        holder.Comunidad?.text = item?.Comunidad
        holder.Nombre?.text = item?.Nombre
        holder.Actividad?.text = item?.Actividad
        holder.Temas?.text = item?.Tema
        holder.Objetivos?.text = item?.Objetivo
        holder.Resumen?.text = item?.Resumen

        if (itemsSeleccionados?.contains(position)!!) {
            holder.vista.setBackgroundColor(Color.LTGRAY)
        } else {
            holder.vista.setBackgroundColor(Color.WHITE)
        }
    }

    fun iniciarActionMode() {
        multiSeleccion = true
    }

    fun destruirActionMode() {
        multiSeleccion = false
        itemsSeleccionados?.clear()
        notifyDataSetChanged()
    }

    fun terminarActionMode() {
        // eliminar elementos seleccionados
        for (item in itemsSeleccionados!!) {
            itemsSeleccionados?.remove(item)
        }
        multiSeleccion = false
        notifyDataSetChanged()
    }

    fun seleccionarItem(index: Int) {
        if (multiSeleccion) {
            if (itemsSeleccionados?.contains(index)!!) {
                itemsSeleccionados?.remove(index)
            } else {
                itemsSeleccionados?.add(index)
            }

            notifyDataSetChanged()
        }
    }

    fun obtenerNumeroElementosSeleccionados(): Int {
        return itemsSeleccionados?.count()!!
    }

    fun eliminarSeleccionados() {
        if (itemsSeleccionados?.count()!! > 0) {
            var itemsEliminados = ArrayList<Registro>()

            for (index in itemsSeleccionados!!) {
                itemsEliminados.add(items?.get(index)!!)
            }

            items?.removeAll(itemsEliminados)
            itemsSeleccionados?.clear()
        }
    }


    class ViewHolder(vista: View, listener: ClickListener, longClickListener: LongClickListener) : RecyclerView.ViewHolder(vista), View.OnClickListener, View.OnLongClickListener {

        var vista = vista
        var Id: TextView? = null
        var Comunidad: TextView? = null
        var Nombre: TextView? = null
        var Actividad: TextView? = null
        var Temas: TextView? = null
        var Objetivos: TextView? = null
        var Resumen: TextView? = null
        var listener: ClickListener? = null
        var longListener: LongClickListener? = null

        init {

            Id = vista.findViewById(R.id.tvIdtem)
            Comunidad = vista.findViewById(R.id.tvComunidadtem)
            Nombre = vista.findViewById(R.id.tvNombretemp)
            Actividad = vista.findViewById(R.id.tvActividadtemp)
            Temas = vista.findViewById(R.id.tvTematemp)
            Objetivos = vista.findViewById(R.id.tvObjetivotemp)
            Resumen = vista.findViewById(R.id.tvResumentemp)



            this.listener = listener
            this.longListener = longClickListener

            vista.setOnClickListener(this)
            vista.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

        override fun onLongClick(v: View?): Boolean {
            this.longListener?.longClick(v!!, adapterPosition)
            return true
        }


    }
}
