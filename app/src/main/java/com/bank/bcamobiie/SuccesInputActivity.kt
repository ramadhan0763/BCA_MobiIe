package com.bank.bcamobiie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bank.bcamobiie.databinding.ActivitySuccesInputBinding
import com.bank.bcamobiie.databinding.AlertWrongCodeAccesBinding
import com.bank.bcamobiie.datastore.Userdata
import com.bank.bcamobiie.viewmodel.InputDataViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuccesInputActivity : AppCompatActivity() {

    private var _binding: ActivitySuccesInputBinding? = null
    private val binding: ActivitySuccesInputBinding get() = _binding!!

    private var _alertWrong: AlertWrongCodeAccesBinding? = null
    private val alertWrong: AlertWrongCodeAccesBinding get() = _alertWrong!!

    private val viewModel: InputDataViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySuccesInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.apply {

            val dataNorek = intent.getStringExtra(DATA_NOREK)
            val code1 = inputCodeAcces.text
            val code2 = inputCodeAcces2.text

            btnOkAccesCode.setOnClickListener {
                if (code1.toString() == code2.toString()) {
                    viewModel.saveSession(Userdata(dataNorek!!, code1.toString(),true))
                    val intent = Intent(this@SuccesInputActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                } else {
                    showAlert()
                }
            }
        }

    }

    private fun showAlert() {
        val alertBuilder = MaterialAlertDialogBuilder(this, R.style.RoundedMaterialDialog)
        _alertWrong = AlertWrongCodeAccesBinding.inflate(layoutInflater)
        val view = alertWrong.root
        alertBuilder.setView(view)
        val dialog = alertBuilder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
        alertWrong.apply {
            btnOkInccoreCode.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    companion object{
        const val DATA_NOREK = "data norek"
        const val DATA_PW = "data pw"
    }

}