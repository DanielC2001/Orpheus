package com.orpheus.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.orpheus.R
import com.orpheus.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root
        val musicFeed = MusicFeedDataset()

        val musicFeedPagerAdapter = ViewPager2Adapter(musicFeed.musicFeed)
        val musicFeedPager = root.findViewById<ViewPager2>(R.id.song_feed_pager)
        musicFeedPager.adapter = musicFeedPagerAdapter

        musicFeedPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}