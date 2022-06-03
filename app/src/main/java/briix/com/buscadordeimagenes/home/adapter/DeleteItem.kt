package briix.com.buscadordeimagenes.home.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import briix.com.buscadordeimagenes.home.PhotosDataModel

class DeleteItem (entity: PhotosDataModel): HomeItem(entity) {
    override fun getSwipeDirs(): Int = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
}