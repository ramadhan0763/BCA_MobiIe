package com.bank.bcamobiie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bank.bcamobiie.adapter.DataTermAdapter
import com.bank.bcamobiie.databinding.ActivityKetentuanBinding
import com.bank.bcamobiie.datadummy.DataDummyTerm

class KetentuanActivity : AppCompatActivity() {

    private var _binding : ActivityKetentuanBinding? = null
    private val binding : ActivityKetentuanBinding get() =  _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityKetentuanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val dataTermList = DataDummyTerm.dataTeksA
        val recyclerView = binding.rvDefinisi
        val adapter = DataTermAdapter(dataTermList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}