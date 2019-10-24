package com.example.project2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDone : Button = findViewById(R.id.done_button)
        btnDone.setOnClickListener { addNickname(it) }

        findViewById<TextView>(R.id.textViewNickName).setOnClickListener {
            updateNickname(it)
        }

    }

    private fun addNickname(view: View) {
        val editTextNickname = findViewById<EditText>(R.id.editTextNickName)
        val nicknameTextView = findViewById<TextView>(R.id.textViewNickName)

        nicknameTextView.text = editTextNickname.text
        editTextNickname.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editTextNickname = findViewById<EditText>(R.id.editTextNickName)
        val doneButton = findViewById<Button>(R.id.done_button)

        editTextNickname.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editTextNickname.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editTextNickname, 0)


    }
}
