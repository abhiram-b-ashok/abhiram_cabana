package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentWaterTankBinding


class WaterTankFragment : Fragment() {
    private lateinit var binding: FragmentWaterTankBinding
    private var selectedTank:Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWaterTankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.l500layout.setOnClickListener()
        {
            selectTank(1)
            selectedTank = 1
        }
        binding.l1000layout.setOnClickListener()
        {
            selectTank(2)
            selectedTank = 2
        }
        binding.l1500layout.setOnClickListener()
        {
            selectTank(3)
            selectedTank = 3
        }
        binding.l2000layout.setOnClickListener()
        {
            selectTank(4)
            selectedTank = 4
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.nextPageButton.setOnClickListener()
        {
            if(selectedTank!=null) {
                findNavController().navigate(R.id.action_waterTankFragment_to_towHookFragment)
            }
            else
            {
                Toast.makeText(context,"Select a Tank",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun selectTank(litre: Int) {
        binding.apply {
            l500layout.setBackgroundResource(if (litre == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            l500Radio.setImageResource(if (litre == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            l1000layout.setBackgroundResource(if (litre == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            l1000Radio.setImageResource(if (litre == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            l1500layout.setBackgroundResource(if (litre == 3) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            l1500Radio.setImageResource(if (litre == 3) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            l2000layout.setBackgroundResource(if (litre == 4) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            l2000Radio.setImageResource(if (litre == 4) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }
}