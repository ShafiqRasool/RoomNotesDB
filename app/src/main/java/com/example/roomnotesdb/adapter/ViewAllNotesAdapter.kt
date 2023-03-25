package com.example.roomnotesdb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomnotesdb.R
import com.example.roomnotesdb.databinding.SingleItemNoteLayoutBinding
import com.example.roomnotesdb.datamodel.Note
import com.example.roomnotesdb.viewmodel.ViewAllNotesViewModel

class ViewAllNotesAdapter(context: Context,list:List<Note>):RecyclerView.Adapter<ViewAllNotesAdapter.viewHolder>(){

    lateinit var notesList:ArrayList<Note>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=SingleItemNoteLayoutBinding.inflate(inflater,parent,false)
        return viewHolder(view)
    }
    fun updateData(list:List<Note>){
        notesList.clear()
        notesList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bindView(notesList.get(position))
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    open class viewHolder(val binding: SingleItemNoteLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(note:Note){
            binding.viewModel=note
            binding.executePendingBindings()
        }

    }
}