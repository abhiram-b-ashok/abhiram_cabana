package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentRoomFloorBinding


class RoomFloorFragment : Fragment() {
  private lateinit var binding: FragmentRoomFloorBinding
    private var selectedFloor:Int? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomFloorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if(selectedFloor!=null){
                findNavController().navigate(R.id.action_roomFloorFragment_to_wardrobeFragment)
            }
            else{
                Toast.makeText(context,"Please Select a type",Toast.LENGTH_SHORT).show()
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.parquetLayout.setOnClickListener() {
            selectedFloor(1)
            selectedFloor = 1
        }
        binding.carpetLayout.setOnClickListener() {
            selectedFloor(2)
            selectedFloor = 2
        }
        binding.tileLayout.setOnClickListener() {
           selectedFloor(3)
            selectedFloor = 3
        }
        binding.nothingTileLayout.setOnClickListener() {
            selectedFloor(4)
            selectedFloor = 4
        }

    }
    private fun selectedFloor(floor:Int)
    {
        binding.apply {
            parquetLayout.setBackgroundResource(if (floor==1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            parquetRadio.setImageResource(if (floor==1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            carpetLayout.setBackgroundResource(if (floor==2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            carpetRadio.setImageResource(if (floor==2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            tileLayout.setBackgroundResource(if (floor==3) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            tileRadio.setImageResource(if (floor==3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            nothingTileLayout.setBackgroundResource(if (floor==4) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            notileRadio.setImageResource(if (floor==4) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }

}