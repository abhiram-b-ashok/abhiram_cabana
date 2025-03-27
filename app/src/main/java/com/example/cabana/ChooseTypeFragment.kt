package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentChooseTypeBinding


class ChooseTypeFragment : Fragment() {
    private lateinit var binding: FragmentChooseTypeBinding
    private var selectedCard :String? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewCabanaButton.setOnClickListener() {
            if (selectedCard!=null)
            findNavController().navigate(ChooseTypeFragmentDirections.actionChooseTypeFragmentToCabanaSizeFragment(selectedCard.toString()))
            else {
                binding.apply {
                    standardLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    customLayout.setBackgroundResource(R.drawable.validity_alert_frame)
            }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.standardCard.setOnClickListener()
        {
            selectedCard = "Standard"
            switchButton(1)
        }
        binding.customCard.setOnClickListener()
        {
            selectedCard = "Custom"
            switchButton(2)
        }

    }
    private fun switchButton(sCard: Int) {
        binding.apply {
            standardRadio.setImageResource(if (sCard == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            standardLayout.setBackgroundResource(if (sCard == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            customRadio.setImageResource(if (sCard == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            customLayout.setBackgroundResource(if (sCard == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
        }
    }
}