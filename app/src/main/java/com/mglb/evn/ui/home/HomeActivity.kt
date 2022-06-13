package com.mglb.evn.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mglb.evn.R
import com.mglb.evn.model.StaffModel
import kotlinx.android.synthetic.main.activity_search_activity.*

class HomeActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    var homeAdapter: HomeAdapter? = null
    var listStaff = mutableListOf<StaffModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_activity)
        setUpRcv()
        setupObsever()
        viewModel.getAlStaff()
        setUpFeatureSearch()

    }

    private fun setUpRcv() {
        homeAdapter = HomeAdapter(this, listStaff, ::onDeleteStaff, ::onEditStaff)
        rcv_staff.layoutManager = LinearLayoutManager(this)
        rcv_staff.adapter = homeAdapter
    }

    private fun onDeleteStaff(staffModel: StaffModel) {


    }

    private fun onEditStaff(staffModel: StaffModel) {

    }

    private fun setupObsever() {
        viewModel.staffResponseLiveData.observe(this) {
            listStaff.clear()
            listStaff.addAll(it)
            homeAdapter?.notifyDataSetChanged()
        }
    }

    private fun setUpFeatureSearch() {
        edt_Search.doAfterTextChanged {
            if (it.isNullOrBlank()) {
                viewModel.getAlStaff()
            } else {
                viewModel.search(it.toString())
            }
        }
    }
}