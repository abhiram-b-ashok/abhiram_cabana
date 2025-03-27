package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentSubmitSuccessBinding


class SubmitSuccessFragment : Fragment() {
private lateinit var binding: FragmentSubmitSuccessBinding
private val args:SubmitSuccessFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubmitSuccessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmButton.setOnClickListener()
        {
            binding.successLayout.visibility = View.GONE
            binding.outputLayout.visibility = View.VISIBLE
        }

        binding.apply {
            typeOutput.text = args.chooseType
            cabanaSizeOutput.text = args.cabanSize
            bathroomSizeOutput.text = args.bathroomSize
            roomFloorOutput.text = args.floorType
            wardrobeOutput.text = args.wardrobeType
            wallOutput.text = args.wallType
            windowSizeOutput.text = args.windowSize
            windowShutterOutput.text = args.shutter
            lifterOutput.text = args.lifterType
            bathroomTypeOutput.text = args.bathRoomType
            val conditions = args.conditionTypes.toList()
            conditionOutput.text = conditions.joinToString { "," }
            outerCoverOutput.text = args.outerCoverType
            waterTankOutput.text = args.waterTankType
            towHookOutput.text = args.hookType
            customNameOutput.text = args.customName

        }


    }

}