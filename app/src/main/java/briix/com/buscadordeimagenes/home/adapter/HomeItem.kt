package briix.com.buscadordeimagenes.home.adapter

import android.view.View
import android.widget.Toast
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.HomeItemBinding
import briix.com.buscadordeimagenes.home.PhotosDataModel
import com.xwray.groupie.viewbinding.BindableItem

open class HomeItem @JvmOverloads constructor(
    private val entity: PhotosDataModel
): BindableItem<HomeItemBinding>() {

    override fun getLayout(): Int {
        return R.layout.home_item
    }

    override fun initializeViewBinding(view: View): HomeItemBinding {
        return  HomeItemBinding.bind(view)
    }

    override fun bind(viewBinding: HomeItemBinding, position: Int) {
        viewBinding.imgPhoto.setImageResource(entity.imagePhoto)
        viewBinding.tvName.text = entity.name
        viewBinding.tvDescription.text = entity.description
        viewBinding.tvId.text = entity.link

        viewBinding.root.setOnClickListener {
            Toast.makeText(
                viewBinding.imgPhoto.context,
                entity.name,
                Toast.LENGTH_SHORT
            ).show() }
    }
}