package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cabana.databinding.FragmentWindowShutterBinding


class WindowShutterFragment : Fragment() {
  private lateinit var binding: FragmentWindowShutterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWindowShutterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            findNavController().navigate(R.id.action_windowShutterFragment_to_liftersFragment)
        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
    }

}