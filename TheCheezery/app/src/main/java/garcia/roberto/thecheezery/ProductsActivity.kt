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

class ProductsActivity : AppCompatActivity() {
    var products = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var category = intent.getStringExtra("category")

        when (category) {
            "coldDrinks" -> addColdDrinks()
            "hotDrinks" -> addHotDrinks()
            "sweets" -> addSweets()
            "salties" -> addSalties()
        }

        var listView = findViewById(R.id.listview) as ListView
        var adapter = ProductAdapter(this, products)
        listView.adapter = adapter

    }

    fun addColdDrinks() {
        products.add(
            Product(
                "Caramel Frap",
                R.drawable.caramel_frap,
                "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.",
                5.0
            )
        )
        products.add(
            Product(
                "Chocolate Frap",
                R.drawable.chocolate_frap,
                "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",
                6.0
            )
        )
        products.add(
            Product(
                "Cold Brew",
                R.drawable.coldbrew,
                "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.",
                3.0
            )
        )
        products.add(
            Product(
                "Matcha Latte",
                R.drawable.matcha,
                "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.",
                4.0
            )
        )
        products.add(
            Product(
                "Oreo Milkshake",
                R.drawable.oreomilkshake,
                "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.",
                7.0
            )
        )
        products.add(
            Product(
                "Peanut Milkshake",
                R.drawable.peanutmilkshake,
                "Vanilla ice cream, mixed with peanut butter and chocolate.",
                7.0
            )
        )
    }

    fun addHotDrinks() {
        products.add(
            Product(
                "Latte",
                R.drawable.latte,
                "Coffee drink made with espresso and steamed milk",
                6.0
            )
        )
        products.add(
            Product(
                "Hot chocolate",
                R.drawable.hotchocolate,
                "Heated drink consisting of shaved chocolate, topped with marshmallows.",
                5.0
            )
        )
        products.add(
            Product(
                "Espresso",
                R.drawable.espresso,
                "Full-flavored, concentrated form of coffee.",
                4.0
            )
        )
        products.add(
            Product(
                "Chai Latte",
                R.drawable.chailatte,
                "Spiced tea concentrate with milk",
                6.0
            )
        )
        products.add(
            Product(
                "Capuccino",
                R.drawable.capuccino,
                "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.",
                7.0
            )
        )
        products.add(
            Product(
                "American coffee",
                R.drawable.americano,
                "Espresso with hot water",
                2.0
            )
        )
    }

    fun addSweets() {
        products.add(
            Product(
                "Blueberry cake",
                R.drawable.blueberrycake,
                "Vanilla cake flavor, topped with cheese topping and blueberries.",
                6.0
            )
        )
        products.add(
            Product(
                "Chocolate cupcake",
                R.drawable.chocolatecupcake,
                "Chocolate cupcakes topped with butter cream and cherries",
                3.0
            )
        )
        products.add(
            Product(
                "Lemon tartalette",
                R.drawable.lemontartalette,
                "Pastry shell with a lemon flavored filling",
                4.0
            )
        )
        products.add(
            Product(
                "Red Velvet cake",
                R.drawable.redvelvetcake,
                "Soft, moist, buttery cake topped with an easy cream cheese frosting.",
                6.0
            )
        )
        products.add(
            Product(
                "Cherry cheesecake",
                R.drawable.strawberrycheesecake,
                "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.",
                7.0
            )
        )
        products.add(
            Product(
                "Tiramisu",
                R.drawable.tiramisu,
                "Coffee-flavored Italian dessert",
                6.0
            )
        )

    }

    fun addSalties() {
        products.add(
            Product(
                "Chicken crepes",
                R.drawable.chickencrepes,
                "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.",
                6.0
            )
        )
        products.add(
            Product(
                "Club Sandwich",
                R.drawable.clubsandwich,
                "A delicious sandwich served with french fries.",
                5.0
            )
        )
        products.add(
            Product(
                "Panini",
                R.drawable.hampanini,
                "Sandwich made with Italian bread  served warmed by grilling.",
                4.0
            )
        )
        products.add(
            Product(
                "Philly cheese steak",
                R.drawable.phillycheesesteak,
                "Smothered in grilled onions, green peppers, mushrooms, and Provolone.",
                6.0
            )
        )
        products.add(
            Product(
                "Nachos",
                R.drawable.nachos,
                "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",
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