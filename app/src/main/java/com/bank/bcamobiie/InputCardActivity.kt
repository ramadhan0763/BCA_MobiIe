package com.bank.bcamobiie

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.bank.bcamobiie.databinding.ActivityInputCardBinding

class InputCardActivity : AppCompatActivity() {
    private var _binding : ActivityInputCardBinding? = null
    private  val binding : ActivityInputCardBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInputCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val editText = binding.inputNumber

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                val text = editable.toString().replace("-", "").replace(" ", "") // Hilangkan tanda "-" dan spasi
                val formattedText = StringBuilder()

                for (i in text.indices) {
                    formattedText.append(text[i])
                    if ((i + 1) % 4 == 0 && i != text.lastIndex) {
                        formattedText.append("-")
                    }
                }

                if (formattedText.toString() != editable.toString()) {
                    editText.removeTextChangedListener(this)
                    editText.setText(formattedText.toString())
                    editText.setSelection(formattedText.length)
                    editText.addTextChangedListener(this)
                }
            }
        })


    }


    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}