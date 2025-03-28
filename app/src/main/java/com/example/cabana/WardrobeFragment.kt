package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentWardrobeBinding


class WardrobeFragment : Fragment() {
    private lateinit var binding: FragmentWardrobeBinding
     private var selectedDoor:String? =null
    private val args:WardrobeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWardrobeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextPageButton.setOnClickListener()
        {
            if(selectedDoor!=null)
            {
                findNavController().navigate(WardrobeFragmentDirections.actionWardrobeFragmentToTheWallFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType,selectedDoor.toString()))
            }
            else{
                binding.apply {
                    slidingLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    hingeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    cornerWardrobeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    walkinWardrobeLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.slidingLayout.setOnClickListener()
        {
            selectWardrobe(1)
            selectedDoor = "Sliding Door"
        }
        binding.hingeLayout.setOnClickListener()
        {
            selectWardrobe(2)
            selectedDoor = "Hinge Door"
        }
        binding.cornerWardrobeLayout.setOnClickListener()
        {
            selectWardrobe(3)
            selectedDoor = "Corner Wardrobe"
        }
        binding.walkinWardrobeLayout.setOnClickListener()
        {
            selectWardrobe(4)
            selectedDoor = "Walk in Wardrobe"
        }
        binding.perCentEllipze.progress = 31
        binding.progressText.text = "31"
    }

    private fun selectWardrobe(door: Int) {
        binding.apply {
            slidingLayout.setBackgroundResource(if (door == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            slidingRadio.setImageResource(if (door == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            hingeLayout.setBackgroundResource(if (door == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            hingeRadio.setImageResource(if (door == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            cornerWardrobeLayout.setBackgroundResource(if (door == 3) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            cornerRadio.setImageResource(if (door == 3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            walkinWardrobeLayout.setBackgroundResource(if (door == 4) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            walkinRadio.setImageResource(if (door == 4) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }


}