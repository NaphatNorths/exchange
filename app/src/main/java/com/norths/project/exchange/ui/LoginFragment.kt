package com.norths.project.exchange.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.norths.project.exchange.MainActivity
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        binding.LoginButton.setOnClickListener {
            val username = binding.UsernameInput.text.toString().trim()
            val password = binding.PasswordInput.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "กรุณากรอกชื่อผู้ใช้และรหัสผ่าน", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == "user" && password == "1234") {
                sharedPreferences.edit()
                    .putBoolean("isLoggedIn", true)
                    .putString("loggedInUser", username)
                    .apply()

                //(requireActivity() as MainActivity).LoginStuts()
                //(requireActivity() as MainActivity).setupProfile()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
            }
            else {
                Toast.makeText(requireContext(), "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show()
            }
        }

        binding.RegisterText.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

