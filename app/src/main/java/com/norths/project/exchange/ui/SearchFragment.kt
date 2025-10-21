package com.norths.project.exchange.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.norths.project.exchange.R
import com.norths.project.exchange.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ONLY inflate layout here
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    // function to do the action in this fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardEve.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ExchangeFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnSearch.setOnClickListener{
            binding.searchView.setQuery("Teddy Bea", false)
        }
        binding.btnSearch2.setOnClickListener{
            binding.searchView.setQuery("Hoody", false)
        }
        binding.btnSearch3.setOnClickListener{
            binding.searchView.setQuery("pokemon", false)
        }
        binding.btnSearch4.setOnClickListener{
            binding.searchView.setQuery("Art", false)
        }
    }


}