package com.hfad.notesapp.roomservice.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hfad.notesapp.roomservice.APP
import com.hfad.notesapp.roomservice.KEY
import com.hfad.notesapp.roomservice.R
import com.hfad.notesapp.roomservice.databinding.FragmentDetailNoteBinding
import com.hfad.notesapp.roomservice.databinding.FragmentStartBinding
import com.hfad.notesapp.roomservice.model.NoteModel

class DetailNoteFragment : Fragment() {

    private var _binding: FragmentDetailNoteBinding? = null
    private val binding get() = _binding!!
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailNoteBinding.inflate(inflater, container, false)
        currentNote = arguments?.getSerializable(KEY) as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailNoteViewModel::class.java]

        binding.tvTitleDetail.text = currentNote.title
        binding.tvDescDetail.text = currentNote.description

        binding.btnDelete.setOnClickListener {
            viewModel.delete(currentNote){}
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}