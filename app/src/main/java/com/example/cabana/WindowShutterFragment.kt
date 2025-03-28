package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentWindowShutterBinding


class WindowShutterFragment : Fragment() {
    private lateinit var binding: FragmentWindowShutterBinding
    private var selectedShutter:String? = null
    private val args:WindowShutterFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWindowShutterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedShutter!=null)
            {
                findNavController().navigate(WindowShutterFragmentDirections.actionWindowShutterFragmentToLiftersFragment(args.chooseType,args.cabanSize,args.bathroomSize,args.floorType, args.wardrobeType,args.wallType,args.windowSize,selectedShutter.toString()))
            }
            else {
                binding.apply {
                    shutterYesLayout.setBackgroundResource(R.drawable.validity_alert_frame)
                    shutterNoLayout.setBackgroundResource(R.drawable.validity_alert_frame)

                }
            }


        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.shutterYesLayout.setOnClickListener()
        {
            selectShutter(1)
            selectedShutter = "Yes"
        }
        binding.shutterNoLayout.setOnClickListener()
        {
            selectShutter(2)
            selectedShutter = "No"
        }
        progressBar()

    }
    private fun progressBar() = binding.apply {
        val percent = ((7f/14f)*100).toInt()
        progressBar.progress = percent
        progressText.text = "$percent%"
    }

    private fun selectShutter(select: Int) {
        binding.apply {
            shutterYesLayout.setBackgroundResource(if (select == 1) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            yesRadio.setImageResource(if (select == 1) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)
            shutterNoLayout.setBackgroundResource(if (select == 2) R.drawable.size_card_layout_background else R.drawable.curve_for_corners)
            noRadio.setImageResource(if (select == 2) R.drawable.baseline_check_circle_24 else R.drawable.checkboxstyle)

        }

    }


}