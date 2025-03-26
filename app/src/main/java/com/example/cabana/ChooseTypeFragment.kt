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
    private var selectedTile :Int? =null
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
            if (selectedTile!=null)
            findNavController().navigate(R.id.action_chooseTypeFragment_to_cabanaSizeFragment)
            else
                Toast.makeText(context, "Please select a tile", Toast.LENGTH_SHORT).show()
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.standardCard.setOnClickListener()
        {
            selectedTile = 1
            switchButton(1)
        }
        binding.customCard.setOnClickListener()
        {
            selectedTile = 2
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