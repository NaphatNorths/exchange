package com.norths.project.exchange.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.norths.project.exchange.databinding.FragmentEditpasswordBinding

class EditPasswordFragment : Fragment() {

    private var _binding: FragmentEditpasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentEditpasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}