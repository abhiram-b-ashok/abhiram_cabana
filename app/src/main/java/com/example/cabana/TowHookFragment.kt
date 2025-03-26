package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentTowHookBinding


class TowHookFragment : Fragment() {
    private lateinit var binding: FragmentTowHookBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTowHookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_towHookFragment_to_customizationFragment)
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.hookYesLayout.setOnClickListener()
        {
            selectHook(1)
        }
        binding.hookNoLayout.setOnClickListener()
        {
            selectHook(2)
        }
    }

    private fun selectHook(select: Int) {
        binding.hookYesLayout.setBackgroundResource(if (select == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
        binding.yesRadio.setImageResource(if (select == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
        binding.hookNoLayout.setBackgroundResource(if (select == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
        binding.noRadio.setImageResource(if (select == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
    }
}