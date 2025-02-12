package garcia.roberto.thecheezery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnColdDrinks = findViewById(R.id.btn_cold_drinks) as Button
        var btnHotDrinks = findViewById(R.id.btn_hot_drinks) as Button
        var btnSweets = findViewById(R.id.btn_sweets) as Button
        var btnSalties = findViewById(R.id.btn_salties) as Button

        btnColdDrinks.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("category", "coldDrinks")
            startActivity(intent)
        }

        btnHotDrinks.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("category", "hotDrinks")
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("category", "sweets")
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("category", "salties")
            startActivity(intent)
        }


    }
}