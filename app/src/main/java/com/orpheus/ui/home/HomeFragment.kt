package com.orpheus.ui.home

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.orpheus.R
import com.orpheus.databinding.FragmentHomeBinding
import java.io.IOException

class HomeFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
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
        mediaPlayer = MediaPlayer()

        val root = binding.root
        val musicFeed = MusicFeedDataset()

        val musicFeedPagerAdapter = ViewPager2Adapter(musicFeed.musicFeed)
        val musicFeedPager = root.findViewById<ViewPager2>(R.id.song_feed_pager)
        musicFeedPager.adapter = musicFeedPagerAdapter
        musicFeedPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        musicFeedPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                playSongAudioForPosition(position)
            }
        })

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.apply {
            if (isPlaying) {
                pause()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.apply {
            if (!isPlaying) {
                start()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mediaPlayer?.release()
        mediaPlayer = null
    }

    private fun playSongAudioForPosition(position: Int) {
        val audioPaths = arrayOf(
            R.raw.frank_ocean_cayendo,
            R.raw.you,
            R.raw.maurice_ii_izzitwurkinfoya,
            R.raw.b_elijah_therapy_v2,
            R.raw.when_i_strike
        )

        try {
            mediaPlayer?.reset()
            mediaPlayer?.setDataSource(requireContext(), Uri.parse("android.resource://${requireContext().packageName}/${audioPaths[position]}"))
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}