package com.hfad.notesapp.roomservice.screens.startNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.hfad.notesapp.roomservice.APP
import com.hfad.notesapp.roomservice.KEY
import com.hfad.notesapp.roomservice.R
import com.hfad.notesapp.roomservice.adapter.NoteAdapter
import com.hfad.notesapp.roomservice.databinding.FragmentStartBinding
import com.hfad.notesapp.roomservice.model.NoteModel

class StartNoteFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartNoteViewModel::class.java)
        viewModel.initDataBase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes.asReversed())
        }
        binding.btnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startNoteFragment_to_addFragment)
        }

    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable(KEY, noteModel)
            APP.navController.navigate(R.id.action_startNoteFragment_to_detailNoteFragment, bundle)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}