package com.bank.bcamobiie.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bank.bcamobiie.R
import com.bank.bcamobiie.activity.AboutActivity
import com.bank.bcamobiie.adapter.MenuAdapter
import com.bank.bcamobiie.databinding.FragmentHomeBinding
import com.bank.bcamobiie.datadummy.dataMenu

class HomeFragment : Fragment(), MenuAdapter.OnMenuItemClickListener{

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.recyclerMenu
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        val adapter = MenuAdapter(dataMenu)
        adapter.setOnMenuItemClickListener(this)
        recyclerView.adapter = adapter


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(menuId: Int) {
        when(menuId){
            1 -> {
                startActivity(Intent(requireContext(), AboutActivity::class.java))
            }
        }
    }
}