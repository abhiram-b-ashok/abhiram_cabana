package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentLiftersBinding


class LiftersFragment : Fragment() {
    private lateinit var binding: FragmentLiftersBinding
    private var selectedLifter:String? = null
    private val args:LiftersFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLiftersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedLifter!=null){
                findNavController().navigate(LiftersFragmentDirections.actionLiftersFragmentToBathroomTypeFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,args.wallType,args.windowSize,args.shutter,selectedLifter.toString()))
            }
            else{
                binding.apply {
                    frontLifterLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    allSidesLifterLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.frontLifterLayout.setOnClickListener()
        {
            lifterSelect(1)
            selectedLifter = "Only Front"
        }
        binding.allSidesLifterLayout.setOnClickListener()
        {
            lifterSelect(2)
            selectedLifter = "All Sides"
        }

    }

    private fun lifterSelect(type: Int) {
        binding.apply {
            frontLifterLayout.setBackgroundResource(if (type == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            frontRadio.setImageResource(if (type == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            allSidesLifterLayout.setBackgroundResource(if (type == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            sideRadio.setImageResource(if (type == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }


}