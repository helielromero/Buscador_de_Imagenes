package briix.com.buscadordeimagenes.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.ActivityHomeBinding
import briix.com.buscadordeimagenes.home.adapter.HomeItem
import com.xwray.groupie.GroupieAdapter

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private lateinit var groupAdapter: GroupieAdapter

    private var items: List<HomeItem> = Home.imageList.map { HomeItem(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        groupAdapter = GroupieAdapter()
        val manager = LinearLayoutManager(this)
        binding.listView.layoutManager = manager
        binding.listView.adapter = groupAdapter
        groupAdapter.update(items)

    }
}