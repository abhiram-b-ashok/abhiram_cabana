package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.collection.emptyLongSet
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentWindowSizeBinding


class WindowSizeFragment : Fragment() {
    private lateinit var binding: FragmentWindowSizeBinding
    private var selectedSize: String? = null
    private val args:WindowSizeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWindowSizeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener() {
            if (selectedSize != null) {
                findNavController().navigate(WindowSizeFragmentDirections.actionWindowSizeFragmentToWindowShutterFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,args.wallType,selectedSize.toString()))
            } else {

                binding.apply {
                    standardSizeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    mediumSizeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    largeSizeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.standardSizeLayout.setOnClickListener()
        {
            selectWindowSize(1)
            selectedSize = "Standard"
        }
        binding.mediumSizeLayout.setOnClickListener()
        {
            selectWindowSize(2)
            selectedSize = "Medium"
        }
        binding.largeSizeLayout.setOnClickListener()
        {
            selectWindowSize(3)
            selectedSize = "Large"
        }
    }

    private fun selectWindowSize(size: Int) {
        binding.apply {
            standardSizeLayout.setBackgroundResource(if (size == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            standardSizeRadio.setImageResource(if (size == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            mediumSizeLayout.setBackgroundResource(if (size == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            mediumSizeRadio.setImageResource(if (size == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            largeSizeLayout.setBackgroundResource(if (size == 3) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            largeSizeRadio.setImageResource(if (size == 3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }

}