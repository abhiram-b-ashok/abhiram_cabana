package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentCabanaSizeBinding


class CabanaSizeFragment : Fragment() {
    private lateinit var binding: FragmentCabanaSizeBinding

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

        binding.nextPageButton.setOnClickListener() {

           /* if(binding.lengthContent.text.isNotEmpty() && binding.widthContent.text.isNotEmpty())
            {
                findNavController().navigate(R.id.action_cabanaSizeFragment_to_bathroomSizeFragment)
            }
            else{
                Toast.makeText(context,"Please give length and width", Toast.LENGTH_SHORT).show()
            }*/

            if (validate()){
                findNavController().navigate(R.id.action_cabanaSizeFragment_to_bathroomSizeFragment)
            }
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }

        binding.lengthContent.addTextChangedListener { binding.tvErrorLength.visibility = View.GONE }

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