package com.example.userprofilemanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    private lateinit var rgNotifications: RadioGroup
    private lateinit var rbEnable: RadioButton
    private lateinit var rbDisable: RadioButton
    private lateinit var btnSaveSettings: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        rgNotifications = view.findViewById(R.id.rgNotifications)
        rbEnable = view.findViewById(R.id.rbEnable)
        rbDisable = view.findViewById(R.id.rbDisable)
        btnSaveSettings = view.findViewById(R.id.btnSaveSettings)

        btnSaveSettings.setOnClickListener {
            val notificationStatus = if (rbEnable.isChecked) "Enabled" else "Disabled"
            Toast.makeText(requireContext(), "Notifications: $notificationStatus", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
