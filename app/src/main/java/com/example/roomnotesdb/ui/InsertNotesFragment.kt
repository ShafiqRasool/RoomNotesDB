package com.example.roomnotesdb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomnotesdb.R
import com.example.roomnotesdb.databinding.FragmentInsertNotesBinding
import com.example.roomnotesdb.viewmodel.InsertNotesViewModel
import com.example.roomnotesdb.viewmodelfactory.InsertNotesViewModelFactory


class InsertNotesFragment : Fragment() {

    lateinit var binding:FragmentInsertNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentInsertNotesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory=InsertNotesViewModelFactory(requireContext())
       val viewModel= ViewModelProvider(this,factory)[InsertNotesViewModel::class.java]
        binding.viewModel=viewModel
    }

    companion object {

    }
}