package com.example.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val LOG_TAG = "NotesListFragment"

class NotesListFragment: Fragment() {
    private lateinit var notesRecyclerView: RecyclerView
    private val notesListViewModel by lazy {
        ViewModelProviders.of(this).get(NotesListViewModel::class.java)
    }

    private inner class NoteHolder(view: View):RecyclerView.ViewHolder(view){
        private lateinit var note: Note
        val noteTitle: TextView = itemView.findViewById(R.id.note_title)
        val noteDescription: TextView = itemView.findViewById(R.id.note_description)

        fun bind(note: Note){
            this.note = note

            noteTitle.text = note.title
            noteDescription.text = note.description
        }
    }

    private inner class NotesListAdapter(var notes: List<Note>): RecyclerView.Adapter<NoteHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
            val view = layoutInflater.inflate(R.layout.item_notes_list,parent,false)
            return NoteHolder(view)
        }

        override fun getItemCount(): Int = notes.size

        override fun onBindViewHolder(holder: NoteHolder, position: Int) {
            val note = notes[position]
            holder.bind(note)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notes_list,container,false)

        notesRecyclerView = view.findViewById(R.id.notes_recycler_view)
        notesRecyclerView.layoutManager = LinearLayoutManager(context)
        val notes = notesListViewModel.notesList
        notesRecyclerView.adapter = NotesListAdapter(notes)

        return view
    }



    companion object{
        fun newInstance():NotesListFragment{
            return NotesListFragment()
        }
    }
}