import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.aquarium.ContentUpdater
import org.hyperskill.aquarium.R

class MyPagerAdapter(private val contentUpdater: ContentUpdater) : RecyclerView.Adapter<PageViewHolder>() {

    override fun getItemCount(): Int = contentUpdater.imageAnimals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder =
        PageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager2, parent, false)
        )

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val imageView: ImageView = holder.itemView.findViewById(R.id.image_view)
        val tvName: TextView = holder.itemView.findViewById(R.id.tv_name)
        val tvDescription: TextView = holder.itemView.findViewById(R.id.tv_description)
        contentUpdater.updateContent(imageView, tvName, tvDescription, position)
    }
}

class PageViewHolder(iV: View) : RecyclerView.ViewHolder(iV)


