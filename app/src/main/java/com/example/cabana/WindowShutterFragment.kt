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
import com.example.cabana.databinding.FragmentWindowShutterBinding


class WindowShutterFragment : Fragment() {
    private lateinit var binding: FragmentWindowShutterBinding
    private var selectedShutter:Int? = null
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
                findNavController().navigate(R.id.action_windowShutterFragment_to_liftersFragment)
            }
            else
            {
                Toast.makeText(context, "Please select a shutter", Toast.LENGTH_SHORT).show()
            }


        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        binding.shutterYesLayout.setOnClickListener()
        {
            selectShutter(1)
            selectedShutter = 1
        }
        binding.shutterNoLayout.setOnClickListener()
        {
            selectShutter(2)
            selectedShutter = 2
        }

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