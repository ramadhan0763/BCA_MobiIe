package com.bank.bcamobiie.ui.akunsaya

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bank.bcamobiie.activity.AboutActivity
import com.bank.bcamobiie.adapter.MenuAdapter
import com.bank.bcamobiie.adapter.MenuMyAccAdapter
import com.bank.bcamobiie.databinding.FragmentAkunSayaBinding
import com.bank.bcamobiie.datadummy.dataMenuMyAcc

class AkunSayaFragment : Fragment(), MenuMyAccAdapter.OnMenuItemClickListener {

    private var _binding: FragmentAkunSayaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentAkunSayaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.rxMenuAkunsaya
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        val adapter = MenuMyAccAdapter(dataMenuMyAcc)
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