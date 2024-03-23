package com.bank.bcamobiie.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bank.bcamobiie.R
import com.bank.bcamobiie.datadummy.DataTerm

class DataTermAdapter(private val dataTerms: List<DataTerm>) : RecyclerView.Adapter<DataTermAdapter.DataTermViewHolder>() {

    inner class DataTermViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val textViewDescription: TextView = itemView.findViewById(R.id.descTerm)
        val textViewNo: TextView = itemView.findViewById(R.id.noTerm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataTermViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_term, parent, false)
        return DataTermViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataTermViewHolder, position: Int) {
        val currentDataTerm = dataTerms[position]
        if (currentDataTerm.title.isEmpty()) {
            holder.textViewTitle.visibility = View.GONE
        } else {
            holder.textViewTitle.visibility = View.VISIBLE
            holder.textViewTitle.text = Html.fromHtml(currentDataTerm.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
        holder.textViewDescription.text = Html.fromHtml(currentDataTerm.text, HtmlCompat.FROM_HTML_MODE_LEGACY)
        holder.textViewNo.text = Html.fromHtml(currentDataTerm.no, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    override fun getItemCount() = dataTerms.size
}