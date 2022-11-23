package com.hfad.notesapp.roomservice.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.roomservice.R
import com.hfad.notesapp.roomservice.model.NoteModel
import com.hfad.notesapp.roomservice.screens.startNote.StartNoteFragment
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = listNote[position].title
        holder.itemView.setOnClickListener {
            StartNoteFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun getItemCount() = listNote.size

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

}