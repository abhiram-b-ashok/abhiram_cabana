package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentBathroomTypeBinding


class BathroomTypeFragment : Fragment() {
    private lateinit var binding: FragmentBathroomTypeBinding
    private var selectedType:Int?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBathroomTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedType!=null)
            {
                findNavController().navigate(R.id.action_bathroomTypeFragment_to_conditionFragment)
            }
            else{
                binding.apply {
                    bathroomStandardLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    bathroomCustomLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.bathroomStandardLayout.setOnClickListener()
        {
            selectBath(1)
            selectedType = 1
        }
        binding.bathroomCustomLayout.setOnClickListener()
        {
            selectBath(2)
            selectedType = 2
        }

    }

    private fun selectBath(type: Int) {
        binding.apply {
            bathroomStandardLayout.setBackgroundResource(if (type == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            bathroomStandardRadio.setImageResource(if (type == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            bathroomCustomLayout.setBackgroundResource(if (type == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            bathroomCustomRadio.setImageResource(if (type == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }
}