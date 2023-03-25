package com.example.roomnotesdb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomnotesdb.adapter.ViewAllNotesAdapter
import com.example.roomnotesdb.databinding.FragmentViewAllNotesBinding
import com.example.roomnotesdb.datamodel.Note
import com.example.roomnotesdb.viewmodel.ViewAllNotesViewModel


class ViewAllNotesFragment : Fragment() {
    lateinit var notesList: MutableList<Note>
    lateinit var binding:FragmentViewAllNotesBinding
    lateinit var viewAdapter:ViewAllNotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentViewAllNotesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //create an adapter
         viewAdapter = ViewAllNotesAdapter(requireContext(), notesList)

        //create viewModel
        val viewModel:ViewAllNotesViewModel by viewModels()

        //observer NotesList Data
        viewModel.notesList.observe(this.viewLifecycleOwner, Observer {
            viewAdapter.updateData(it)
        })

        //bind recycler view with adapter
        binding.recyclerviewNotes.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(requireContext())
            adapter=viewAdapter
        }



    }

}