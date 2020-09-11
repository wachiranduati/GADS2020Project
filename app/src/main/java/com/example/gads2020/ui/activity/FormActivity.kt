package com.example.gads2020.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gads2020.R
import com.example.gads2020.ui.netCalls.RepositoryRetriever
import com.example.gads2020.ui.netCalls.learners.LearnersRepoRetriever
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.*

class FormActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        submissionBtn.setOnClickListener(this)
        setSupportActionBar(formToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        formToolBar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.submissionBtn -> submitData()
        }
    }

    private fun submitData() {

        val mainActivityJob = Job()

        AlertDialog.Builder(this)
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _, _ ->
//                Toast.makeText(this, "clicked yes", Toast.LENGTH_SHORT).show()

                val errorHandler = CoroutineExceptionHandler { _, exception ->
                    this?.let {
                        AlertDialog.Builder(it)
                            .setMessage("Submission not successfull")
                            .setIcon(android.R.drawable.ic_dialog_alert).show()
                    }
                }
                val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
                coroutineScope.launch(errorHandler) {
                    RepositoryRetriever().submitData( emailAddressEdtTxt.text.toString(),
                        firstNameEdtTxt.text.toString(), lastNameEdtTxt.text.toString(),githublinkEdtTxt.text.toString() )

                    AlertDialog.Builder(this@FormActivity)
                        .setMessage("Submission successfull")
                        .setIcon(android.R.drawable.ic_dialog_alert).show()
                }
            }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }
}