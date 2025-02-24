import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba10.FieldType
import com.example.davaleba10.ListItem
import com.example.davaleba10.databinding.ItemListBinding

class SettingsAdapter : ListAdapter<ListItem, SettingsAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem) {
            binding.apply {
                itemIconStart.setImageResource(item.startIcon)
                itemText.text = item.text
                languageChange.visibility = View.GONE
                itemIconEnd.visibility = View.VISIBLE
                itemSwitch.visibility = View.GONE
                itemText.setTextColor(Color.WHITE)

                when (item.fieldType) {
                    FieldType.NORMAL -> {}
                    FieldType.LANGUAGE -> {
                        languageChange.visibility = View.VISIBLE
                        languageChange.text = item.extraText
                    }

                    FieldType.DARK_MODE -> {
                        itemSwitch.visibility = View.VISIBLE
                        itemIconEnd.visibility = View.GONE
                    }

                    FieldType.LOGOUT -> {
                        itemText.setTextColor(Color.RED)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
            return oldItem == newItem
        }
    }
}
