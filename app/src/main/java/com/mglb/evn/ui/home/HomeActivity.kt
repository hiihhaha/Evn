package com.mglb.evn.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mglb.evn.R
import com.mglb.evn.model.StaffModel
import com.mglb.evn.utils.isAdmin
import kotlinx.android.synthetic.main.activity_home_activity.*
import kotlinx.android.synthetic.main.view_left_menu.*
import kotlinx.android.synthetic.main.view_left_menu.view.*

class HomeActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    var homeAdapter: HomeAdapter? = null
    var listStaff = mutableListOf<StaffModel>()

    val userProfile by lazy {
        intent.getSerializableExtra("data") as StaffModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_activity)
        setUpRcv()
        setupObsever()
        viewModel.getAlStaff()
        setUpFeatureSearch()
        setUpLeftMenu()
        setUpEvent()

    }
private fun setUpEvent(){
    img_lef_menu.setOnClickListener {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer_layout.openDrawer(GravityCompat.START)
    }
    img_lef_menu_cancel.setOnClickListener {

    }
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
    private fun setUpLeftMenu(){
        btn_create_staff.isVisible = userProfile.isAdmin()

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