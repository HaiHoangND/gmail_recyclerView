package com.example.gmail

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class EmailAdapter(val messages: ArrayList<EmailModel>) :
    RecyclerView.Adapter<EmailAdapter.EmailItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return EmailItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun onBindViewHolder(holder: EmailItemViewHolder, position: Int) {
        val email = messages[position]
        holder.avatar.text = email.username.first().uppercaseChar().toString()
        holder.username.text = messages[position].username
        holder.message.text = messages[position].message
        holder.time.text = messages[position].time
        if (email.selected) {
            holder.selected.setImageResource(R.drawable.yellow_star)
        } else {
            holder.selected.setImageResource(R.drawable.star)
        }
        holder.selected.setOnClickListener {
            // Toggle the selected status
            email.selected = !email.selected

            // Update the star image based on the new selected status
            if (email.selected) {
                holder.selected.setImageResource(R.drawable.yellow_star)
            } else {
                holder.selected.setImageResource(R.drawable.star)
            }
        }
        holder.mainItem.setOnLongClickListener {
            email.showSecondary = !email.showSecondary
            holder.secondaryItem.visibility = View.VISIBLE
            holder.mainItem.visibility = View.INVISIBLE
            true
        }

        // Xử lý sự kiện khi người dùng nhấn nút cancel trong secondaryItem
        holder.cancelButton.setOnClickListener {
            email.showSecondary = false
            holder.mainItem.visibility = View.VISIBLE
            holder.secondaryItem.visibility = View.INVISIBLE
        }
    }

    class EmailItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: TextView
        val username: TextView
        val message: TextView
        val time: TextView
        val selected: ImageView
        val mainItem: ConstraintLayout = itemView.findViewById(R.id.mainItem)
        val secondaryItem: ConstraintLayout = itemView.findViewById(R.id.secondaryItem)
        val cancelButton: ImageView = itemView.findViewById(R.id.cancel)

        init {
            avatar = itemView.findViewById(R.id.avatar)
            username = itemView.findViewById(R.id.username)
            message = itemView.findViewById(R.id.message)
            time = itemView.findViewById(R.id.time)
            selected = itemView.findViewById(R.id.selected)
        }
    }

}