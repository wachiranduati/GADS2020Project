package com.example.gads2020.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gads2020.R
import com.example.gads2020.ui.Data.topskill.TopSkillIQItem
import kotlinx.android.synthetic.main.skill_iq_list_item.view.*

class TopIQAdapter(private val learners : List<TopSkillIQItem>) : RecyclerView.Adapter<TopIQAdapter.MyViewHolder>(){
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val LearnerName : TextView = view.findViewById(R.id.iqLearnerNameTxtVw)
        val LearnerInfo : TextView = view.findViewById(R.id.iqLearnerInfoTxtVw)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_iq_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.LearnerName.text = learners[position].name
        holder.LearnerInfo.text = "${learners[position].score} skill IQ Score, ${learners[position].country}"
    }

    override fun getItemCount(): Int = learners.size
}