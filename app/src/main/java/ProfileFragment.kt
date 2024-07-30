package com.example.userprofilemanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var spGender: Spinner
    private lateinit var btnSaveProfile: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        etName = view.findViewById(R.id.etName)
        etEmail = view.findViewById(R.id.etEmail)
        spGender = view.findViewById(R.id.spGender)
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile)

        val genderAdapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        )
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter = genderAdapter

        btnSaveProfile.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val gender = spGender.selectedItem.toString()
            Toast.makeText(requireContext(), "Profile Saved: $name, $email, $gender", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
