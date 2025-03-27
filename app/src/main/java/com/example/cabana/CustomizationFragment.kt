package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentCustomizationBinding


class CustomizationFragment : Fragment() {
    private lateinit var binding: FragmentCustomizationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomizationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (nameValidation())
            {
                findNavController().navigate(R.id.action_customizationFragment_to_submitSuccessFragment)
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
    }
    private fun nameValidation(): Boolean
    {
        var isValid = true;
        if(binding.nameEditText.text.isEmpty()) {
            binding.invalidName.visibility = View.VISIBLE
            isValid = false
        }
        return isValid
    }
}