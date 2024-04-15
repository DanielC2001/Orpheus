package com.orpheus.ui.playlists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.orpheus.databinding.FragmentPlaylistsBinding
import com.orpheus.R

class PlaylistsFragment : Fragment() {

    private var _binding: FragmentPlaylistsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlaylistsBinding.inflate(inflater, container, false)

        val root = binding.root
        val gridView = root.findViewById<GridView>(R.id.playlist_grid)
        val playlistArrayList: ArrayList<PlaylistModel> = ArrayList()
        val playlistNames: ArrayList<String> = arrayListOf("Pop","Hip-Hop","R&B","Rock","Jazz","Metal","Pop-Rock","Punk", "Alt-Rock","Rap")
        for (name in playlistNames) {
            playlistArrayList.add(PlaylistModel(name, R.drawable.candy_mkgee))
        }

        gridView.adapter = PlaylistAdapter(requireContext(), playlistArrayList)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}