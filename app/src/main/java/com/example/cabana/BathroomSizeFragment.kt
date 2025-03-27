package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentBathroomSizeBinding

class BathroomSizeFragment : Fragment() {
    private lateinit var binding: FragmentBathroomSizeBinding
   private var selectedSize:Int? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBathroomSizeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener() {
            if (selectedSize!=null)
            {
                findNavController().navigate(R.id.action_bathroomSizeFragment_to_roomFloorFragment)
            }
            else
            {
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
            selectedLayout(1)
            selectedSize =1
        }
        binding.mediumSizeLayout.setOnClickListener()
        {
            selectedLayout(2)
            selectedSize = 2
        }
        binding.largeSizeLayout.setOnClickListener()
        {
            selectedLayout(3)
            selectedSize = 3
        }
    }

    private fun selectedLayout(layout:Int) {
        binding.apply {
            standardSizeLayout.setBackgroundResource(if (layout==1)R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            standardSizeRadio.setImageResource(if (layout==1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            mediumSizeLayout.setBackgroundResource(if (layout==2)R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            mediumRadio.setImageResource(if (layout==2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            largeSizeLayout.setBackgroundResource(if (layout==3)R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            largeRadio.setImageResource(if (layout==3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }
}