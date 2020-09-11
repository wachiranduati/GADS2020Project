package com.example.gads2020.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gads2020.R
import com.example.gads2020.ui.Data.tophours.TopHourLearners
import com.example.gads2020.ui.Data.tophours.TopHourLearnersItem
import kotlinx.android.synthetic.main.learning_leaders_list_item.view.*

class TopLearnersAdapter(private val learners : List<TopHourLearnersItem>) : RecyclerView.Adapter<TopLearnersAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val learnerNm : TextView = view.findViewById(R.id.learnerName)
        val learnerInf : TextView = view.findViewById(R.id.LearnerInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.learning_leaders_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.learnerNm.text = learners[position].name
        holder.learnerInf.text = "${learners[position].hours} Learning hours, ${learners[position].country}"
    }

    override fun getItemCount(): Int = learners.size
}