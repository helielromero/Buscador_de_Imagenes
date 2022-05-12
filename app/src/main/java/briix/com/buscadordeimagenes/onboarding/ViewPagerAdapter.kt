package briix.com.buscadordeimagenes.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.databinding.BoardItemBinding

class ViewPagerAdapter(
    private val boardList: List<Board>,
    private val onItemSelected: OnItemSelected? = null
) : RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BoardItemBinding.inflate(inflater, parent, false)
        return BoardViewHolder(view, onItemSelected )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
    }

    override fun getItemCount()=boardList.size

    inner class BoardViewHolder(
        private val binding: BoardItemBinding,
        private val onItemSelected: OnItemSelected? = null
    ): RecyclerView.ViewHolder(binding.root) {

        private val contenedor = binding.container
        private val imagen = binding.imageView
        private val titulo = binding.textViewTitulo
        private val descripcion = binding.textViewDescripcion
        private val boton = binding.bottomSiguinte

        fun bind(board: Board) = with(binding) {
            container.background = ContextCompat.getDrawable(root.context,board.fondo)
            imageView.setImageResource(board.imagen)
            titulo.text = board.titulo
            descripcion.text = board.descripcion

            if (adapterPosition.equals(boardList.size-1)){
                boton.text = "finalizar"
            }

            boton.setOnClickListener {
                onItemSelected?.onClickListener(adapterPosition)
            }

        }
    }

    interface OnItemSelected {
        fun onClickListener (position: Int)
    }
}