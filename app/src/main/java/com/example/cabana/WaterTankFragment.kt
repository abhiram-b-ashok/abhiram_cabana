package com.example.cabana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentWaterTankBinding


class WaterTankFragment : Fragment() {
    private lateinit var binding: FragmentWaterTankBinding
    private var selectedTank:String? = null
    private val args:WaterTankFragmentArgs by navArgs()
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
            selectedTank = "500 L"
        }
        binding.l1000layout.setOnClickListener()
        {
            selectTank(2)
            selectedTank = "1000 L"
        }
        binding.l1500layout.setOnClickListener()
        {
            selectTank(3)
            selectedTank = "1500 L"
        }
        binding.l2000layout.setOnClickListener()
        {
            selectTank(4)
            selectedTank = "2000L"
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.nextPageButton.setOnClickListener()
        {
            if(selectedTank!=null) {
                findNavController().navigate(WaterTankFragmentDirections.actionWaterTankFragmentToTowHookFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,args.wallType,args.windowSize,args.shutter,args.lifterType,args.bathRoomType,args.conditionTypes,args.outerCoverType,selectedTank.toString()))
            }
            else
            {
                binding.apply {
                    l500layout.setBackgroundResource(R.drawable.validity_alert_frame)
                    l1000layout.setBackgroundResource(R.drawable.validity_alert_frame)
                    l1500layout.setBackgroundResource(R.drawable.validity_alert_frame)
                    l2000layout.setBackgroundResource(R.drawable.validity_alert_frame)
                }
            }
        }
        binding.perCentEllipze.progress = 93
        binding.progressText.text = "93"

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