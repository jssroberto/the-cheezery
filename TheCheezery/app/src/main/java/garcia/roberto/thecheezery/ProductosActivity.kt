package garcia.roberto.thecheezery

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProducts()

        var listView = findViewById(R.id.listview) as ListView
        var adapter = ProductAdapter(this, coldDrinks)
        listView.adapter = adapter

    }

    fun addProducts() {
        coldDrinks.add(
            Product(
                "Caramel Frap",
                R.drawable.caramel_frap,
                "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.",
                5.0
            )
        )
        coldDrinks.add(
            Product(
                "Chocolate Frap",
                R.drawable.chocolate_frap,
                "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",
                6.0
            )
        )
        coldDrinks.add(
            Product(
                "Cold Brew",
                R.drawable.coldbrew,
                "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.",
                3.0
            )
        )
        coldDrinks.add(
            Product(
                "Matcha Latte",
                R.drawable.matcha,
                "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.",
                4.0
            )
        )
        coldDrinks.add(
            Product(
                "Oreo Milkshake",
                R.drawable.oreomilkshake,
                "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.",
                7.0
            )
        )
        coldDrinks.add(
            Product(
                "Peanut Milkshake",
                R.drawable.peanutmilkshake,
                "Vanilla ice cream, mixed with peanut butter and chocolate.",
                7.0
            )
        )
    }

    private class ProductAdapter : BaseAdapter {
        var products = ArrayList<Product>()
        var context: Context? = null

        constructor(context: Context, products: ArrayList<Product>) {
            this.context = context
            this.products = products
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val product = this.products[position]
            var inflator = LayoutInflater.from(this.context)
            var view = inflator.inflate(R.layout.product_view, null)

            var image = view.findViewById(R.id.product_image) as ImageView
            var name = view.findViewById(R.id.product_name) as TextView
            var description = view.findViewById(R.id.product_description) as TextView
            var price = view.findViewById(R.id.product_price) as TextView

            image.setImageResource(product.image)
            name.setText(product.name)
            description.setText(product.description)
            price.setText("$${product.price}")

            return view
        }


    }
}