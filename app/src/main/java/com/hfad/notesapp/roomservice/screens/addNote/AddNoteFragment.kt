package com.hfad.notesapp.roomservice.screens.addNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hfad.notesapp.roomservice.APP
import com.hfad.notesapp.roomservice.R
import com.hfad.notesapp.roomservice.databinding.FragmentAddBinding
import com.hfad.notesapp.roomservice.databinding.FragmentDetailNoteBinding
import com.hfad.notesapp.roomservice.model.NoteModel

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[AddNoteViewModel::class.java]
        binding.btnAdd.setOnClickListener {
            val newTitle = binding.etAddTitle.text.toString()
            val newDescription = binding.etAddDesc.text.toString()
            viewModel.insert(NoteModel(title = newTitle, description = newDescription)){}
            APP.navController.navigate(R.id.action_addFragment_to_startNoteFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addFragment_to_startNoteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}