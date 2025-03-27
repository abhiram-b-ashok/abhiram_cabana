package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cabana.databinding.FragmentConditionBinding


class ConditionFragment : Fragment() {
    private lateinit var binding: FragmentConditionBinding
    private lateinit var adapter: ConditionAdapter
    private var selectedCondition: Int? = null
    private val clickedList: ArrayList<String> = ArrayList()
    private val args: ConditionFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConditionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextPageButton.setOnClickListener()
        {
            if (selectedCondition != null) {
                findNavController().navigate(
                    ConditionFragmentDirections.actionConditionFragmentToOuterCoverFragment(
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
                        clickedList.toTypedArray()
                    )
                )
            } else {
                Toast.makeText(context, "Please select a condition", Toast.LENGTH_SHORT).show()
            }

        }
        binding.buildBackArrow.setOnClickListener()
        {
            findNavController().navigateUp()
        }
        val list = arrayListOf(
            ConditionItems("(1)TON"),
            ConditionItems("(1)TON"),
            ConditionItems("(2)TON"),
            ConditionItems("(1)TON X 2"),
            ConditionItems("(2,5)TON"),
            ConditionItems("TON X 2"),
            ConditionItems("WITHOUT"),
        )


        adapter = ConditionAdapter(list, object : ConditionSelectListener {
            override fun clickCondition(position: Int, item: ConditionItems) {
                list.forEachIndexed { index, conditionItems ->
                    if (index == position) {
                        conditionItems.isSelected = !conditionItems.isSelected
                        selectedCondition = position
                        clickedList.add(conditionItems.condition)
                    }
                    // else conditionItems.isSelected = false
                }
                adapter.notifyDataSetChanged()
            }
        })
        binding.conditionRecyclers.adapter = adapter
        binding.conditionRecyclers.layoutManager = GridLayoutManager(requireContext(), 2)


    }
}

