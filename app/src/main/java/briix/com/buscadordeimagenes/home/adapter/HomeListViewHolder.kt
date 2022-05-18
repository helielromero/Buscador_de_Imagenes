package briix.com.buscadordeimagenes.home.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.databinding.HomeItemBinding
import briix.com.buscadordeimagenes.home.PhotosDataModel

class HomeListViewHolder (view:View):RecyclerView.ViewHolder(view) {

    val binding= HomeItemBinding.bind(view)


    fun render (entidad: PhotosDataModel){
        binding.imgPhoto.setImageResource(entidad.imagePhoto)
        binding.tvName.text = entidad.name
        binding.tvDescripcion.text = entidad.description
        binding.tvId.text = entidad.link

        itemView.setOnClickListener {
            Toast.makeText(
            binding.imgPhoto.context,
            entidad.name,
            Toast.LENGTH_SHORT
        ).show() }

    }
}