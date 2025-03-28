package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentCustomizationBinding


class CustomizationFragment : Fragment() {
    private lateinit var binding: FragmentCustomizationBinding
    private val args: CustomizationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCustomizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (nameValidation()) {
                findNavController().navigate(
                    CustomizationFragmentDirections.actionCustomizationFragmentToSubmitSuccessFragment(
                        args.chooseType,
                        args.cabanSize,
                        args.bathroomSize,
                        args.floorType,
                        args.wardrobeType,
                        args.wallType,
                        args.windowSize,
                        args.shutter,
                        args.lifterType,
                        args.bathRoomType,
                        args.conditionTypes,
                        args.outerCoverType,
                        args.waterTankType,
                        args.hookType,
                        binding.nameEditText.text.toString()
                    )
                )
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.perCentEllipze.progress = 100
        binding.progressText.text = "100"

        binding.nameEditText.addTextChangedListener {  binding.invalidName.visibility = View.GONE }
    }

    private fun nameValidation(): Boolean {
        var isValid = true;
        if (binding.nameEditText.text.isEmpty()) {
            binding.invalidName.visibility = View.VISIBLE
            isValid = false
        }
        return isValid
    }
}