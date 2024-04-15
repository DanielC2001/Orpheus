package com.orpheus.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.orpheus.R
import com.orpheus.databinding.FragmentSearchBinding
import com.orpheus.ui.playlists.PlaylistAdapter
import com.orpheus.ui.playlists.PlaylistModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        val root = binding.root
        val gridView = root.findViewById<GridView>(R.id.browse_all_grid)
        val playlistArrayList: ArrayList<PlaylistModel> = ArrayList()
        val playlistNames: ArrayList<String> = arrayListOf("Pop","Hip-Hop","R&B","Rock","Jazz","Metal","Pop-Rock","Punk", "Alt-Rock","Rap")
        for (name in playlistNames) {
            playlistArrayList.add(PlaylistModel(name, R.drawable.candy_mkgee))
        }

        val recentSearchPlaylist1 = root.findViewById<View>(R.id.recent_search_playlist_1)
        val recentSearch1TextView = recentSearchPlaylist1.findViewById<TextView>(R.id.playlist_name)
        recentSearch1TextView.text = getString(R.string.dummy_album_name_1)

        val recentSearchPlaylist2 = root.findViewById<View>(R.id.recent_search_playlist_2)
        val recentSearch2TextView = recentSearchPlaylist2.findViewById<TextView>(R.id.playlist_name)
        recentSearch2TextView.text = getString(R.string.dummy_album_name_2)

        gridView.adapter = PlaylistAdapter(requireContext(), playlistArrayList)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}