package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentTowHookBinding


class TowHookFragment : Fragment() {
    private lateinit var binding: FragmentTowHookBinding
    private var selectedHook: String? = null
    private val args: TowHookFragmentArgs by navArgs()
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
            if (selectedHook!=null) {
                findNavController().navigate(TowHookFragmentDirections.actionTowHookFragmentToCustomizationFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,args.wallType,args.windowSize,args.shutter,args.lifterType,args.bathRoomType,args.conditionTypes,args.outerCoverType,args.waterTankType,selectedHook.toString()))
            }
            else {
                binding.apply {
                    hookYesLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    hookNoLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.hookYesLayout.setOnClickListener()
        {
            selectHook(1)
            selectedHook = "Yes"
        }
        binding.hookNoLayout.setOnClickListener()
        {
            selectHook(2)
            selectedHook = "No"
        }
    }

    private fun selectHook(select: Int) {
        binding.hookYesLayout.setBackgroundResource(if (select == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
        binding.yesRadio.setImageResource(if (select == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
        binding.hookNoLayout.setBackgroundResource(if (select == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
        binding.noRadio.setImageResource(if (select == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
    }
}