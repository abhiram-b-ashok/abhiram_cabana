package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentOuterCoverBinding


class OuterCoverFragment : Fragment() {
    private lateinit var binding: FragmentOuterCoverBinding
    private var selectedCover: Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOuterCoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedCover != null) {
                findNavController().navigate(R.id.action_outerCoverFragment_to_waterTankFragment)
            } else {
                binding.apply {
                    ironLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    fiperLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.ironLayout.setOnClickListener()
        {
            selectCover(1)
            selectedCover = 1
        }
        binding.fiperLayout.setOnClickListener()
        {
            selectCover(2)
            selectedCover = 2
        }


    }

    private fun selectCover(type: Int) {
        binding.apply {
            ironLayout.setBackgroundResource(if (type == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            ironRadio.setImageResource(if (type == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            fiperLayout.setBackgroundResource(if (type == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            fiperRadio.setImageResource(if (type == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }
    }


}