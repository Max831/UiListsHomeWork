package com.homework.uilistshomework

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.ItemAddressBinding
import com.homework.uilistshomework.databinding.ItemInfoBinding

class Adapter : RecyclerView.Adapter<BaseViewHolder>() {

    var list: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        Log.d("KUKU", "KUKU")
        Log.d(viewType.toString(), viewType.toString())
        Log.d(viewType.toString(), viewType.toString())
        Log.d(viewType.toString(), viewType.toString())
        println(viewType)
        println(viewType)
        return when (viewType) {
            R.layout.item_address -> AddressViewHolder(parent)
            else -> InfoViewHolder(parent)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is Item.Address -> R.layout.item_address
            is Item.Info -> R.layout.item_info
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        when (val item = list[position]) {
            is Item.Address -> (holder as AddressViewHolder).bind(item)
            is Item.Info -> (holder as InfoViewHolder).bind(item)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class AddressViewHolder(private val binding: ItemAddressBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun bind(item: Item) {
            val tmpCast: Item.Address = item as Item.Address
            binding.itemAddress.text = tmpCast.address
        }
    }

    class InfoViewHolder(private val binding: ItemInfoBinding) :
        BaseViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        @SuppressLint("SetTextI18n")
        override fun bind(item: Item) {
            val tmpCast: Item.Info = item as Item.Info
            binding.itemInfo.text = tmpCast.name.name +"\nCall "+ tmpCast.number.phone
        }
    }
}
