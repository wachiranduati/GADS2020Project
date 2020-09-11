package com.example.gads2020.ui.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gads2020.R
import com.example.gads2020.ui.adapters.TopLearnersAdapter
import com.example.gads2020.ui.netCalls.RepositoryRetriever
import com.example.gads2020.ui.netCalls.learners.LearnersRepoRetriever
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root : View =  inflater.inflate(R.layout.fragment_first, container, false)
        setUpFragmentData()
        return root
    }

    private fun setUpFragmentData() {
        val mainActivityJob = Job()

        //2 Handle exceptions if any
        val errorHandler = CoroutineExceptionHandler { _, exception ->
            activity?.let {
                AlertDialog.Builder(it).setTitle("Error")
                    .setMessage(exception.message)
                    .setPositiveButton("ok") { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
            }
        }

        //3 the Coroutine runs using the Main (UI) dispatcher
        val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
        coroutineScope.launch(errorHandler) {
            //4
            val resultList = LearnersRepoRetriever().getTopHourLearners()
            val adpt = TopLearnersAdapter(resultList)
            val lytmng : LinearLayoutManager = LinearLayoutManager(activity)
            topLearnersRecyclerView.apply {
                setHasFixedSize(true)
                adapter = adpt
                layoutManager = lytmng
            }
        }
    }

}