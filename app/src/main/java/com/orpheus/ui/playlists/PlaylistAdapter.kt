package com.orpheus.ui.playlists;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.orpheus.R

class PlaylistAdapter(context: Context, playlistModelArrayList: ArrayList<PlaylistModel>):
    ArrayAdapter<PlaylistModel>(context, 0, playlistModelArrayList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var listItemView = convertView

            if (listItemView == null) {
                listItemView = LayoutInflater.from(context).inflate(R.layout.playlist, parent, false)
            }

            val playlistModel: PlaylistModel? = getItem(position)
            val playlistName = listItemView!!.findViewById<TextView>(R.id.playlist_name)
            val playlistImage = listItemView.findViewById<ImageView>(R.id.playlist_img)

            playlistName.text = (playlistModel!!.playlistName)
            playlistImage.setImageResource(playlistModel.playlistImgId)

            return listItemView
        }
}
