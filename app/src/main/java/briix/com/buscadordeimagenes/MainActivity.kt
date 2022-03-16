package briix.com.buscadordeimagenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BuscadorDeImagenes)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}