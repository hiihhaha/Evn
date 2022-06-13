package com.mglb.evn.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mglb.evn.databinding.ItemSearchStaffBinding
import com.mglb.evn.model.StaffModel

class HomeAdapter(
    var context : Context,
    var listStaff : MutableList<StaffModel>,
    var setOnDeleteStaff : (item : StaffModel) -> Unit,
    var setOnEditStaff : (item : StaffModel) -> Unit,


) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemSearchStaffBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchStaffBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var staff = listStaff[position]
        var binding = holder.binding
        binding.txtName.text = staff.lastName + staff.firstName
        binding.txtDepartment.text = staff.department
        binding.txtRole.text = staff.staffRole?.role?.name
        binding.imgEdit.setOnClickListener {
            setOnEditStaff.invoke(staff)
        }
        binding.itemDelete.setOnClickListener {
            setOnDeleteStaff.invoke(staff)
        }

    }

    override fun getItemCount(): Int = listStaff.size
    }