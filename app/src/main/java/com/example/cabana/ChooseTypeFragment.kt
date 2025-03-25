package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentChooseTypeBinding


class ChooseTypeFragment : Fragment() {
 private lateinit var binding: FragmentChooseTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentChooseTypeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewCabanaButton.setOnClickListener(){
            findNavController().navigate(R.id.action_chooseTypeFragment_to_cabanaSizeFragment)
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.standardCard.isSelected = false
        binding.customCard.isSelected = false
        binding.standardCard.setOnClickListener()
        {
            binding.standardCard.isSelected = true

        }
        if(binding.standardCard.isSelected){
            binding.standardCard.setBackgroundResource(R.drawable.size_card_layout_background)
            binding.standardRadio.setImageResource(R.drawable.baseline_check_circle_24)
        }
        binding.customCard.setOnClickListener(){
            binding.customCard.isSelected=true
        }
        if(binding.customCard.isSelected)
        {
            binding.standardCard.setBackgroundResource(R.drawable.size_card_layout_background)
            binding.customRadio.setImageResource(R.drawable.baseline_check_circle_24)
        }
    }



}