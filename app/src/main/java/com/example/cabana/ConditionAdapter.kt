package com.example.cabana

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.test.isSelected
import androidx.recyclerview.widget.RecyclerView
import com.example.cabana.databinding.ConditionRecyclerViewBinding

class ConditionAdapter(
    private val list: List<ConditionItems>,
    private val listener: ConditionSelectListener
) : RecyclerView.Adapter<ConditionAdapter.ConditionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConditionViewHolder {
        val binding =
            ConditionRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConditionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConditionViewHolder, position: Int) {
        holder.bindData(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ConditionViewHolder(private val binding: ConditionRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: ConditionItems, listener: ConditionSelectListener) {
            binding.apply {
                conditionText.text = item.condition
                if (item.isSelected) {
                    conditionLayout.setBackgroundResource(R.drawable.size_card_layout_background)


                } else {
                    conditionLayout.setBackgroundResource(R.drawable.curve_for_corners)
                }
                root.setOnClickListener {
                    listener.clickCondition(adapterPosition, item)
                }
            }
        }
    }
}

interface ConditionSelectListener {
    fun clickCondition(position: Int, item: ConditionItems)
}