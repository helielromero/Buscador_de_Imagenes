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

        private val container = binding.container
        private val image = binding.imageView
        private val title = binding.textViewTitle
        private val description= binding.textViewDescription
        private val bottom = binding.bottomSiguiente

        fun bind(board: Board) = with(binding) {
            container.background = ContextCompat.getDrawable(root.context,board.bottom)
            imageView.setImageResource(board.image)
            title.text = board.title
            description.text = board.description

            if (adapterPosition.equals(boardList.size-1)){
                bottom.text = "finalizar"
            }

            bottom.setOnClickListener {
                onItemSelected?.onClickListener(adapterPosition)
            }

        }
    }

    interface OnItemSelected {
        fun onClickListener (position: Int)
    }
}