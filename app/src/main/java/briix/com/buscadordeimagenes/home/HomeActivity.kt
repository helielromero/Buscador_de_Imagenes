package briix.com.buscadordeimagenes.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val listItems by lazy { getList() }


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = Adaptador(this, listItems)
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val selectedItemText = parent.getItemAtPosition(position) as Entidad

            Toast.makeText(this, "Selected : ${selectedItemText.nombre}", Toast.LENGTH_SHORT).show()
        }

    }


    fun getList() = arrayListOf<Entidad>(
        Entidad(
            R.drawable.storefront,
            "San Gabriel Chilac",
            "chilac",
            "http://www."
        ),
        Entidad(
            R.drawable.francia,
            "Francia",
            "Francia",
            "https:"
        ),
        Entidad(
            R.drawable.chichenitza,
            "Chichen-itza",
            "boca del pozo",
            "https:"
        )
    )


}