package com.example.notesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null){
            val fragment = NotesListFragment.newInstance()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }
}