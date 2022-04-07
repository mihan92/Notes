package com.example.notes.screens.start


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.adapter.NoteAdapter
import com.example.notes.databinding.FragmentStartBinding
import com.example.notes.model.NoteModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDataBase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) {
            adapter.setList(it.reversed())
        }
        binding.btAdd.setOnClickListener {
            APP.navHostFragment.navController.navigate(R.id.action_startFragment_to_addFragment)
        }
    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navHostFragment.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
    }
}