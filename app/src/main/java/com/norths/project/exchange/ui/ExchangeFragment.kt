package com.norths.project.exchange.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentExchangeBinding


class ExchangeFragment : Fragment() {

    private var _binding: FragmentExchangeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentExchangeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.LinearLayoutClick.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemProfileFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.LinearLayoutClick2.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemProfileFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.LinearLayoutClick3.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemProfileFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.LinearLayoutClick4.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemProfileFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnAddFavorites.setOnClickListener{
            Toast.makeText(requireContext(), "เพิ่มรายการไปที่ Favorites แล้ว", Toast.LENGTH_SHORT).show()
        }
    }

}