package com.example.notes.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.databinding.FragmentAddBinding
import com.example.notes.model.NoteModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val view = ViewModelProvider(this).get(AddViewModel::class.java)
        binding.btAdd.setOnClickListener {
            val tit = binding.editTextTitle.text.toString()
            val desc = binding.editTextDescription.text.toString()
            view.insert(NoteModel(title = tit, description = desc, id = 0)){}
            APP.navHostFragment.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btBack.setOnClickListener {
            APP.navHostFragment.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
    }
}