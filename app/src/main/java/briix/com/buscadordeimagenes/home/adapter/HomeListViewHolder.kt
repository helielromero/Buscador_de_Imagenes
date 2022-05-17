package briix.com.buscadordeimagenes.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.HomeItemBinding
import briix.com.buscadordeimagenes.home.Entidad

class HomeListViewHolder (view:View):RecyclerView.ViewHolder(view) {

    val binding= HomeItemBinding.bind(view)


    fun render (entidad: Entidad){
        binding.imgPhoto.setImageResource(entidad.imgFoto)
        binding.tvName.text = entidad.nombre
        binding.tvDescripcion.text = entidad.descripcion
        binding.tvId.text = entidad.link

        itemView.setOnClickListener {
            Toast.makeText(
            binding.imgPhoto.context,
            entidad.nombre,
            Toast.LENGTH_SHORT
        ).show() }

    }
}