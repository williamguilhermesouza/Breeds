package br.com.breeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BreedsAdapter(var items: List<Breed>): RecyclerView.Adapter<BreedsAdapter.ViewHolder>(), AdapterItemsContract {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BreedItemBinding = BreedItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Breed>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BreedsAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: BreedItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }
    }
}