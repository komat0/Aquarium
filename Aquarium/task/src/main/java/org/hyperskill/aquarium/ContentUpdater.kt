package org.hyperskill.aquarium

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ContentUpdater(
    private val activity: MainActivity,
    internal val imageAnimals: List<String>,
    private val nameAnimals: List<String>,
    private val listDescription: List<String>,
) {
    fun updateContent(imageView: ImageView, tvName: TextView, tvDescription: TextView, page: Int) {
        val imageRes = imageAnimals[page]
        val name = nameAnimals[page]
        val description = listDescription[page]

        Picasso.get()
            .load(imageRes)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .resize(400, 300)
            .centerInside()
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    Toast.makeText(activity, "Success!", Toast.LENGTH_SHORT).show()
                }

                override fun onError(e: Exception?) {
                    Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                }
            })

        tvName.text = name
        tvDescription.text = description
    }
}