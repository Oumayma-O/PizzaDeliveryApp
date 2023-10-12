import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzadeliveryapp.R
import com.example.pizzadeliveryapp.activities.DetailsActivity
import com.example.pizzadeliveryapp.activities.adapters.MainHorizontalItem

class MainHorAdapter(
    private val context: Context,
    private val items: List<MainHorizontalItem>
) : RecyclerView.Adapter<MainHorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val priceTextView: TextView=itemView.findViewById(R.id.priceTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.horizontal_card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.imageResId)
        holder.titleTextView.text = item.title
        holder.priceTextView.text = item.price.toString() + " DT"
        holder.descriptionTextView.text = item.description

        // Set an OnClickListener for the "Place Order" button
        val placeOrderButton = holder.itemView.findViewById<Button>(R.id.placeOrder)

        placeOrderButton.setOnClickListener {
            val selectedPizzaTitle = item.title
            val selectedPizzaImageResId=item.imageResId

            // Start the Details Activity with the selected pizza title
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("selectedPizzaTitle", selectedPizzaTitle)
            intent.putExtra("selectedPizzaImageResId", selectedPizzaImageResId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
