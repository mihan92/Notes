package com.example.notes.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.databinding.FragmentDetailBinding
import com.example.notes.model.NoteModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val view = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.tvTitle.text = currentNote.title
        binding.tvDescription.text = currentNote.description

        binding.btBack.setOnClickListener{
            APP.navHostFragment.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btDelete.setOnClickListener {
            view.delete(currentNote){}
            APP.navHostFragment.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

}