package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentBathroomSizeBinding

class BathroomSizeFragment : Fragment() {
   private lateinit var binding: FragmentBathroomSizeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBathroomSizeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener(){
            findNavController().navigate(R.id.action_bathroomSizeFragment_to_roomFloorFragment)
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.standardSizeLayout.setOnClickListener()
        {
            binding.standardSizeRadio.setImageResource(R.drawable.baseline_check_circle_24)
            binding.standardSizeLayout.setBackgroundResource(R.drawable.size_card_layout_background)
        }
    }
}