package com.example.gmail.adapters

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.gmail.R
import com.example.gmail.models.Email
import kotlin.random.Random

class EmailAdapter(private val context: Context, private val emails: List<Email>) : BaseAdapter() {
    private val colors = listOf(
        R.color.color1,
        R.color.color2,
        R.color.color3,
        R.color.color4,
        R.color.color5,
        R.color.color6,
        R.color.color7,
        R.color.color8
    )

    override fun getCount(): Int = emails.size
    override fun getItem(position: Int): Any = emails[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.email_item, parent, false)

        val email = emails[position]

        val senderIcon = view.findViewById<TextView>(R.id.sender_icon)
        val senderName = view.findViewById<TextView>(R.id.sender_name)
        val emailSubject = view.findViewById<TextView>(R.id.email_subject)
        val emailContent = view.findViewById<TextView>(R.id.email_content)
        val emailTime = view.findViewById<TextView>(R.id.email_time)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)

        senderIcon.text = email.icon.toString()
        val randomColor = colors[Random.nextInt(colors.size)]
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.OVAL
        drawable.setColor(ContextCompat.getColor(context, randomColor))

        // Set the drawable as background
        senderIcon.background = drawable

        senderName.text = email.sender
        emailSubject.text = email.subject
        emailContent.text = email.content
        emailTime.text = email.time

        // Set the initial star icon based on isStarred status
        starIcon.setImageResource(if (email.isStarred) R.drawable.baseline_star_24 else R.drawable.baseline_star_border_24)

        // Toggle star status on click
        starIcon.setOnClickListener {
            email.isStarred = !email.isStarred
            notifyDataSetChanged()  // Refresh the list to update the icon
        }

        return view
    }
}

