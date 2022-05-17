package briix.com.buscadordeimagenes.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    fun initRecyclerView(){
        val manager= LinearLayoutManager(this)

        binding.listView.layoutManager= manager
        binding.listView.adapter= HomeListAdapter(HomeList.imagenList)



    }

}