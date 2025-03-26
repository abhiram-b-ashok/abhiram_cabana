package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentLiftersBinding


class LiftersFragment : Fragment() {
    private lateinit var binding: FragmentLiftersBinding
    private var selectedLifter:Int? = null
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
                findNavController().navigate(R.id.action_liftersFragment_to_bathroomTypeFragment)
            }
            else{
                Toast.makeText(context, "Please select a lifter", Toast.LENGTH_SHORT).show()
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.frontLifterLayout.setOnClickListener()
        {
            lifterSelect(1)
            selectedLifter = 1
        }
        binding.allSidesLifterLayout.setOnClickListener()
        {
            lifterSelect(2)
            selectedLifter = 2
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