package com.usj.onboardingapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usj.onboardingapp.R
import com.usj.onboardingapp.model.Book
import com.usj.onboardingapp.model.MediaItem
import com.usj.onboardingapp.model.Movie

class LibraryAdapter(val mediaItems: List<MediaItem>) : RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LibraryViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.library_item_list_layout, parent, false)
        return LibraryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: LibraryViewHolder,
        position: Int
    ) {
        val mediaItem = mediaItems[position]
        holder.libraryItemIv.setImageResource(R.drawable.baseline_image_24)
        holder.titleTv.text = mediaItem.title
        holder.descriptionTv.text = "Test description"
        holder.authorTv.text = if(mediaItem is Book) (mediaItem).author else (mediaItem as Movie).director
        holder.genreTv.text = if(mediaItem is Book)(mediaItem).genre.toString() else (mediaItem as Movie).genre.toString()

//        if (position == itemCount-1) {
//            holder.divider.visibility = View.GONE
//        }
    }

    override fun getItemCount(): Int {
        return mediaItems.size
    }

    class LibraryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val libraryItemIv: ImageView
        val titleTv: TextView
        val descriptionTv: TextView
        val authorTv: TextView
        val genreTv: TextView

        val divider: View

        init {
            libraryItemIv = view.findViewById(R.id.libraryItemIv)
            titleTv = view.findViewById(R.id.libraryItemTv)
            descriptionTv = view.findViewById(R.id.descriptionTv)
            authorTv = view.findViewById(R.id.authorTv)
            genreTv = view.findViewById<TextView>(R.id.genreTv)
            divider = view.findViewById<View>(R.id.divider)
        }
    }
}