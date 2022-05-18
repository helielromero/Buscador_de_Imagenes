package briix.com.buscadordeimagenes.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import briix.com.buscadordeimagenes.R
import briix.com.buscadordeimagenes.databinding.ActivityOnboardingBinding
import briix.com.buscadordeimagenes.home.HomeActivity

class OnboardingActivity : AppCompatActivity(), ViewPagerAdapter.OnItemSelected {

    private val binding: ActivityOnboardingBinding by lazy {
        ActivityOnboardingBinding.inflate(layoutInflater)
    }

    private val boardList by lazy { getList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ViewPagerAdapter(boardList, this)
        binding.viewPager.adapter = adapter
    }

    override fun onClickListener(position: Int) {
        if (position == (boardList.size - 1)) {
            val intent = Intent(this, HomeActivity ::class.java)
            startActivity(intent)
        } else {
            binding.viewPager.setCurrentItem(position + 1)
        }
    }

    private fun getList() = listOf(
        Board(
            bottom = R.color.primaryColor,
            image = R.drawable.storefront,
            title = "Bienvenido",
            description = "Te damos la bienvenida a la app imagenes al azar ",
        ),
        Board(
            bottom = R.color.primaryColor,
            image = R.drawable.ic_imagen,
            title = "Imagenes",
            description = "En esta aplicacion podras buscar imagenes de cualquier tipo.",
        ),
        Board(
            bottom = R.color.primaryColor,
            image = R.drawable.ic_descargar,
            title = "Podras descargar las imagenes que te gusten o darles me gusta.",
            description = "",
        ),
        Board(
            bottom = R.color.primaryColor,
            image = R.drawable.ic_comenzar,
            title = "Estas listo!!!",
            description = "Comenzar!!!!",
        )
    )
}