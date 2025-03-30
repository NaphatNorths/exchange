package com.norths.project.exchange.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentItemprofileBinding

class ItemProfileFragment : Fragment() {
    private var _binding: FragmentItemprofileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentItemprofileBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf("ตัวเลือกที่ 1", "ตัวเลือกที่ 2", "ตัวเลือกที่ 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, itemList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.itemSpinner.adapter = adapter

        binding.btnExchangeitem.setOnClickListener {
            Toast.makeText(requireContext(), "ส่งคำขอแรกเปลี่ยนแล้ว", Toast.LENGTH_SHORT).show()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ExchangeFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}