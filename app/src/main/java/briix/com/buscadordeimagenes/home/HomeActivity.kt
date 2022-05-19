package briix.com.buscadordeimagenes.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.ActivityHomeBinding
import briix.com.buscadordeimagenes.home.adapter.HomeListAdapter

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initRecyclerView()
    }

   private fun  initRecyclerView(){
        val manager= LinearLayoutManager(this)
        binding.listView.layoutManager= manager
        binding.listView.adapter= HomeListAdapter(Home.imageList)
   }
}