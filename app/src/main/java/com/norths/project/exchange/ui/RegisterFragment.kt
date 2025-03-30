package com.norths.project.exchange.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RegisterButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val username = binding.UsernameInput.text.toString()
        val email = binding.EmailInput.text.toString()
        val firstName = binding.FirstnameInput.text.toString()
        val lastName = binding.LastnameInput.text.toString()
        val address = binding.AddressInput.text.toString()
        val password = binding.PasswordInput.text.toString()

        if (username.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show()
            return
        }


        Toast.makeText(requireContext(), "ลงทะเบียนสำเร็จ!", Toast.LENGTH_SHORT).show()

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
