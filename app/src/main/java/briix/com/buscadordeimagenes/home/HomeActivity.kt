package briix.com.buscadordeimagenes.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.ActivityHomeBinding
import briix.com.buscadordeimagenes.home.adapter.DeleteItem
import briix.com.buscadordeimagenes.home.adapter.HomeItem
import briix.com.buscadordeimagenes.home.decoration.SwipeTouchCallback
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.TouchCallback

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private lateinit var groupAdapter: GroupieAdapter
    private val imageList: List<PhotosDataModel> by lazy {  Home.imageList }
    // datos =[1,,2,3,4..]
    // item = [Item[1], Item[2],Item[3]...]
    //gropieAdapter = items

    private var items: List<HomeItem> = Home.imageList.map { HomeItem(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        initRecyclerView()
        createItems()
    }

    private fun createItems()  {
       imageList.forEach{ model->
           groupAdapter.add(DeleteItem(model))
       }
    }

    private fun initRecyclerView() {
        groupAdapter = GroupieAdapter()
        val manager = LinearLayoutManager(this)
        binding.listView.layoutManager = manager
        binding.listView.adapter = groupAdapter
        binding.listView.also {
            ItemTouchHelper(touchCallback).attachToRecyclerView(it)
        }
        groupAdapter.update(items)


    }

    private val touchCallback: TouchCallback by lazy {
        object : SwipeTouchCallback() {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = groupAdapter.getItem(viewHolder.adapterPosition)
                // Change notification to the adapter happens automatically when the section is
                // changed.
                groupAdapter.remove(item)
            }
        }
    }
}