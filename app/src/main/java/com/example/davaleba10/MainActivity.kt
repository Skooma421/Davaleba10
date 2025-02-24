package com.example.davaleba10

import SettingsAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davaleba10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val settingsList = listOf(
            ListItem(R.drawable.person, "Edit Profile", null, FieldType.NORMAL),
            ListItem(R.drawable.location, "Address", null, FieldType.NORMAL),
            ListItem(R.drawable.notification, "Notification", null, FieldType.NORMAL),
            ListItem(R.drawable.payment, "Payment", null, FieldType.NORMAL),
            ListItem(R.drawable.security, "Security", null, FieldType.NORMAL),
            ListItem(
                R.drawable.language,
                "Language",
                null,
                FieldType.LANGUAGE,
                extraText = "English (US)"
            ),
            ListItem(R.drawable.dark_mode, "Dark Mode", null, FieldType.DARK_MODE),
            ListItem(R.drawable.privacy, "Privacy Policy", null, FieldType.NORMAL),
            ListItem(R.drawable.help_center, "Help Center", null, FieldType.NORMAL),
            ListItem(R.drawable.invite, "Invite People", null, FieldType.NORMAL),
            ListItem(R.drawable.logout_red, "Logout", null, FieldType.LOGOUT),
        )

        val adapter = SettingsAdapter()

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }

        adapter.submitList(settingsList)
    }
}
