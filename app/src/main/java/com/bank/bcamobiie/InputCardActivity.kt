package com.bank.bcamobiie

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.bank.bcamobiie.databinding.ActivityInputCardBinding
import com.bank.bcamobiie.utils.Utils.removeHyphens


class InputCardActivity : AppCompatActivity() {


    private var _binding: ActivityInputCardBinding? = null
    private val binding: ActivityInputCardBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInputCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        processInput()

    }
    private fun processInput(){
        val editText = binding.inputNumber

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                val text = editable.toString().replace("-", "")
                    .replace(" ", "")
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
        val inputNorek = binding.inputNumber


        binding.btnOkInput
            .setOnClickListener {
                val intent = Intent(this, SuccesInputActivity::class.java)
                intent.putExtra(SuccesInputActivity.DATA_NOREK, inputNorek.text.toString().removeHyphens())
                startActivity(intent)
            }
    }


    override fun onBackPressed() {
        super.onBackPressed()
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
    }

}