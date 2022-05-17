package briix.com.buscadordeimagenes.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.home.Entidad

class HomeListAdapter(private val imagenList: List<Entidad>) :RecyclerView.Adapter<HomeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeListViewHolder(layoutInflater.inflate(R.layout.home_item, parent,false))

    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val item= imagenList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int {
       return imagenList.size

    }
}