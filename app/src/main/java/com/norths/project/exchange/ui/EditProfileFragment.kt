package com.norths.project.exchange.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.norths.project.exchange.MainActivity
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentEditprofileBinding

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditprofileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentEditprofileBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackProfileEdit.setOnClickListener {
            (activity as? MainActivity)?.setBottomNavVisible(true)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .commit()
        }
    }
}