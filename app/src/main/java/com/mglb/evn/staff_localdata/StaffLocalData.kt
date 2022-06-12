package com.mglb.evn.staff_localdata

import com.mglb.evn.model.StaffModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where

class StaffLocalData {
    val config = RealmConfiguration.Builder()
        .allowQueriesOnUiThread(true)
        .allowWritesOnUiThread(true)
        .build()
    val realm: Realm = Realm.getInstance(config)

     fun getAllStaff(): MutableList<StaffModel> {
        // you can also filter a collection
        val listStaff: List<StaffModel> = realm.where(StaffModel::class.java).findAll()
        return listStaff.toMutableList()
    }

     fun createStaff(staffModel: StaffModel) {
        realm.executeTransaction { transactionRealm ->
            transactionRealm.insert(staffModel)
        }
    }

     fun deleteStaff(staffModel: StaffModel) {
        realm.executeTransaction { transactionRealm ->
            val innerYetAnotherTask: StaffModel =
                transactionRealm.where<StaffModel>().equalTo("id", staffModel.id).findFirst()!!
            innerYetAnotherTask.deleteFromRealm()
        }
    }

     fun editStaff(staffModel: StaffModel) {
        realm.executeTransaction { transactionRealm ->
            val innerOtherTask: StaffModel =
                transactionRealm.where<StaffModel>().equalTo("id", staffModel.id).findFirst()!!
            innerOtherTask.firstName = staffModel.firstName
            innerOtherTask.lastName = staffModel.lastName
            innerOtherTask.email = staffModel.email
            innerOtherTask.password = staffModel.password
            innerOtherTask.department = staffModel.department
            innerOtherTask.address = staffModel.address
            innerOtherTask.createdAt = staffModel.createdAt
            innerOtherTask.createdBy = staffModel.createdBy
            innerOtherTask.staffRole = staffModel.staffRole
        }
    }

     fun login(email: String, password: String): StaffModel? {
        val staff = realm.where(StaffModel::class.java).contains("email",email)
            .contains("password",password).findFirst()
        return staff
    }
    fun seachStaff(textSearch : String) : MutableList<StaffModel>{
        val listStaff = realm.where(StaffModel::class.java).contains("firstName",textSearch).findAll()
        return listStaff
    }
}

