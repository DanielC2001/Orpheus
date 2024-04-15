package com.orpheus.ui.home;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orpheus.R

class ViewPager2Adapter(private val dataSet: Array<MusicFeedElement>): RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val songImageView: ImageView
        val songNameTextView: TextView
        val songArtistTextView: TextView

        init {
            songImageView = view.findViewById(R.id.song_album_art)
            songNameTextView = view.findViewById(R.id.song_name)
            songArtistTextView = view.findViewById(R.id.song_artist)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //Inflates i.e creates views here
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.song_recommendation,viewGroup,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //Edit content of views here
        viewHolder.songImageView.setImageResource(dataSet[position].albumArtResID)
        viewHolder.songArtistTextView.text = dataSet[position].artistName
        viewHolder.songNameTextView.text = dataSet[position].songName
    }

    override fun getItemCount(): Int = dataSet.size
}
