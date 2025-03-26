package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentWardrobeBinding


class WardrobeFragment : Fragment() {
    private lateinit var binding: FragmentWardrobeBinding
     private var selectedDoor:Int? =null
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
                findNavController().navigate(R.id.action_wardrobeFragment_to_theWallFragment)
            }
            else{
                Toast.makeText(context,"Please select an item", Toast.LENGTH_SHORT).show()
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.slidingLayout.setOnClickListener()
        {
            selectWardrobe(1)
            selectedDoor = 1
        }
        binding.hingeLayout.setOnClickListener()
        {
            selectWardrobe(2)
            selectedDoor = 2
        }
        binding.cornerWardrobeLayout.setOnClickListener()
        {
            selectWardrobe(3)
            selectedDoor = 3
        }
        binding.walkinWardrobeLayout.setOnClickListener()
        {
            selectWardrobe(4)
            selectedDoor = 4
        }
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