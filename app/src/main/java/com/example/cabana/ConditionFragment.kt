package com.example.cabana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cabana.databinding.FragmentConditionBinding


class ConditionFragment : Fragment() {
    private lateinit var binding: FragmentConditionBinding
    private lateinit var adapter: ConditionAdapter
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
            findNavController().navigate(R.id.action_conditionFragment_to_outerCoverFragment)
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
                    if (index==position)
                        conditionItems.isSelected = !conditionItems.isSelected
                   // else conditionItems.isSelected = false
                }
                adapter.notifyDataSetChanged()
            }
        })
        binding.conditionRecyclers.adapter = adapter
        binding.conditionRecyclers.layoutManager = GridLayoutManager(requireContext(), 2)


    }


}
