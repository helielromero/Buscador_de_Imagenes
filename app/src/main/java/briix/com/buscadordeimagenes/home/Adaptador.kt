package briix.com.buscadordeimagenes.home

import android.content.Context
import android.widget.BaseAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import briix.com.buscadordeimagenes.R
import android.widget.TextView
import java.util.ArrayList

class Adaptador(private val context: Context, private val listItems: ArrayList<Entidad>) : BaseAdapter() {

    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return listItems.size
    }

    override fun getItem(i: Int): Any {
        return listItems[i]
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View {

        val Item = getItem(i) as Entidad
        val view = LayoutInflater.from(context).inflate(R.layout.home_item, null)
        val imgPhoto = view.findViewById<ImageView>(R.id.imgPhoto)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcion)
        val tvId = view.findViewById<TextView>(R.id.tvId)
        imgPhoto.setImageResource(Item.imgFoto)
        tvName.text = Item.nombre
        tvDescripcion.text = Item.descripcion
        tvId.text = Item.link
        return view
    }
}