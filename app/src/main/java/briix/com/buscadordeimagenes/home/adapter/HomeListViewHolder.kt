package briix.com.buscadordeimagenes.home.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.databinding.HomeItemBinding
import briix.com.buscadordeimagenes.home.PhotosDataModel

class HomeListViewHolder (view:View):RecyclerView.ViewHolder(view) {

    private val binding= HomeItemBinding.bind(view)

    fun render (entity: PhotosDataModel){
        binding.imgPhoto.setImageResource(entity.imagePhoto)
        binding.tvName.text = entity.name
        binding.tvDescription.text = entity.description
        binding.tvId.text = entity.link

        itemView.setOnClickListener {
            Toast.makeText(
            binding.imgPhoto.context,
            entity.name,
            Toast.LENGTH_SHORT
        ).show() }
    }
}