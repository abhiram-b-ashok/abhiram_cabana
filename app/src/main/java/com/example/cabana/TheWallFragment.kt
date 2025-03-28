package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentTheWallBinding

class TheWallFragment : Fragment() {
    private lateinit var binding: FragmentTheWallBinding
    private var selectedWall: String? = null
    private val args:TheWallFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTheWallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedWall != null) {
                findNavController().navigate(TheWallFragmentDirections.actionTheWallFragmentToWindowSizeFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,selectedWall.toString()))
            } else {
                binding.apply {
                    wallpaperLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    paintLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    nothingLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }
            }
            binding.buildBackArrow.setOnClickListener()
            {
                findNavController().navigateUp()
            }
            binding.wallpaperLayout.setOnClickListener()
            {
                selectPaint(1)
                selectedWall = "Wallpaper"
            }
            binding.paintLayout.setOnClickListener()
            {
                selectPaint(2)
                selectedWall = "Paint"
            }
            binding.nothingLayout.setOnClickListener()
            {
                selectPaint(3)
                selectedWall = "Nothing"
            }
       progressBar()
        }
    private fun progressBar() = binding.apply {
        val percent = ((5f/14f)*100).toInt()
        progressBar.progress = percent
        progressText.text = "$percent%"
    }
        private fun selectPaint(wall: Int) {
            binding.apply {
                wallpaperLayout.setBackgroundResource(if (wall == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
                wallpaperRadio.setImageResource(if (wall == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
                paintLayout.setBackgroundResource(if (wall == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
                paintRadio.setImageResource(if (wall == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
                nothingLayout.setBackgroundResource(if (wall == 3) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
                nothingRadio.setImageResource(if (wall == 3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            }
        }
    }
