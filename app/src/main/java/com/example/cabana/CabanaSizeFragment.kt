package com.example.cabana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cabana.databinding.FragmentCabanaSizeBinding


class CabanaSizeFragment : Fragment() {
    private lateinit var binding: FragmentCabanaSizeBinding
    private val args:CabanaSizeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        if (!::binding.isInitialized)
        binding = FragmentCabanaSizeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            nextPageButton.setOnClickListener {
                if (validate()){
                    findNavController().navigate(CabanaSizeFragmentDirections.actionCabanaSizeFragmentToBathroomSizeFragment(args.chooseType, binding.lengthContent.text.toString()))
                }
            }
            buildBackArrow.setOnClickListener {
                findNavController().navigateUp()
            }
            lengthContent.addTextChangedListener { tvErrorLength.visibility = View.GONE }
            widthContent.addTextChangedListener { tvErrorWidth.visibility = View.GONE }
            setProgressBar()

        }
    }

    private fun setProgressBar() = binding.apply {
        progressText.text = "8%"
        percentageBar.apply {
            max = 100
            progress = 80
            isIndeterminate = false
        }
    }

    private fun validate():Boolean {
        var isValid = true
        if(binding.lengthContent.text.isEmpty()){
            isValid = false
            binding.tvErrorLength.visibility = View.VISIBLE
        }
       if(binding.widthContent.text.isEmpty()){
            isValid = false
            binding.tvErrorWidth.visibility = View.VISIBLE
        }
        return isValid
    }


}