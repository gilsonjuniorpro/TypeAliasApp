package typealiasapp.ca

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import typealiasapp.ca.databinding.ItemLanguageBinding

class MainAdapter(
    private val languages: List<String>
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    var onItemClicked: (ItemClickedAlias)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.create(parent, onItemClicked)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(languages[position])
    }

    override fun getItemCount(): Int = languages.count()

    class MainViewHolder(
        private val binding: ItemLanguageBinding,
        private val onItemClicked: (ItemClickedAlias)?
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(language: String){
            binding.tvLanguage.text = language

            itemView.setOnClickListener{
                onItemClicked?.invoke(language)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onItemClicked: (ItemClickedAlias)?
            ) : MainViewHolder {
                val itemBinding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MainViewHolder(itemBinding, onItemClicked)
            }
        }
    }
}
