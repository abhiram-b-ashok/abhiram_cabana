package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentRoomFloorBinding


class RoomFloorFragment : Fragment() {
  private lateinit var binding: FragmentRoomFloorBinding
    private var selectedFloors:String? =null
    private val args: RoomFloorFragmentArgs by navArgs()
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
            if(selectedFloors!=null){
                findNavController().navigate(RoomFloorFragmentDirections.actionRoomFloorFragmentToWardrobeFragment(args.chooseType,args.cabanSize,args.bathroomSize, selectedFloors.toString()))
            }
            else{
                binding.apply {
                    parquetLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    carpetLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    tileLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    nothingTileLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }

            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.parquetLayout.setOnClickListener() {
            selectedFloor(1)
            selectedFloors = "Parquet"
        }
        binding.carpetLayout.setOnClickListener() {
            selectedFloor(2)
            selectedFloors = "Carpet"
        }
        binding.tileLayout.setOnClickListener() {
           selectedFloor(3)
            selectedFloors = "Marble"
        }
        binding.nothingTileLayout.setOnClickListener() {
            selectedFloor(4)
            selectedFloors = "Nothing"
        }
        binding.perCentEllipze.progress = 23
        binding.progressText.text = "23"

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