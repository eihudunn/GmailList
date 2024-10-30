package com.example.gmail

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gmail.adapters.EmailAdapter
import com.example.gmail.models.Email

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emails = listOf(
            Email("Edurila.com", "$19 Only (First 10 spots) - Bestselling...", "Are you looking to learn web designing from scratch? Limited spots available, sign up now!", "12:34 PM", 'E', true),
            Email("Chris Abad", "Help make Campaign Monitor better...", "We're conducting a survey to improve our services. Let us know your thoughts! No images needed.", "11:22 AM", 'C', false),
            Email("Tuto.com", "8h de formation gratuite...", "Découvrez les nouvelles formations en ligne : Photoshop, SEO, Blender, CSS, WordPress et plus encore.", "11:04 AM", 'T', true),
            Email("support", "Société Ovh : suivi de vos services...", "Votre service OVH est en ligne. Consultez vos paramètres et gérez vos services via votre compte.", "10:26 AM", 'S', false),
            Email("Matt from Ionic", "The New Ionic Creator Is Here!", "Announcing the all-new Creator, built to help you design stunning apps faster and easier.", "10:00 AM", 'M', true),
            Email("LinkedIn", "Top jobs for you this week", "We've found some great job opportunities that match your profile. Check them out!", "9:45 AM", 'L', false),
            Email("Google Play", "New games and updates!", "Discover the latest games and updates on Google Play. There's something new for everyone!", "9:30 AM", 'G', false),
            Email("Slack", "Weekly Summary - Catch up with your team", "Here is your weekly summary of team activities. Stay updated with the latest conversations.", "8:20 AM", 'S', true),
            Email("GitHub", "Your repository has a new star!", "Congratulations! Your repository just received a new star. Keep up the good work!", "7:10 AM", 'G', true),
            Email("Medium", "New stories for you", "Read personalized stories based on your interests, recommended by Medium editors.", "6:50 AM", 'M', false)
        )

        val emailListView = findViewById<ListView>(R.id.email_list_view)
        val adapter = EmailAdapter(this, emails)
        emailListView.adapter = adapter
    }
}