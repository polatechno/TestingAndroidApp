package com.polatechno.testingtutorial.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.polatechno.testingtutorial.R
import com.polatechno.testingtutorial.data.local.ShoppingItem
import javax.inject.Inject

class ShoppingItemAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivShoppingImage: ImageView = itemView.findViewById(R.id.ivShoppingImage)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvShoppingItemAmount: TextView = itemView.findViewById(R.id.tvShoppingItemAmount)
        val tvShoppingItemPrice: TextView = itemView.findViewById(R.id.tvShoppingItemPrice)
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<ShoppingItem>() {
        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var shoppingItems: List<ShoppingItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ShoppingItemViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_shopping,
            parent,
            false
        )
    )

    override fun getItemCount() = shoppingItems.size

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val shoppingItem = shoppingItems[position]
        holder.itemView.apply {
            glide.load(shoppingItem.imageUrl).into(holder.ivShoppingImage)

            holder.tvName.text = shoppingItem.name
            val amountText = "${shoppingItem.amount}x"
            holder.tvShoppingItemAmount.text = amountText
            val priceText = "${shoppingItem.price}€"
            holder.tvShoppingItemPrice.text = priceText

        }
    }

}