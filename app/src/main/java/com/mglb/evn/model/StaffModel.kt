package com.mglb.evn.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

class StaffModel(
    @PrimaryKey
    var id : Int = 0,
    var firstName : String? =null,
    var lastName : String? = null,
    var email : String? = null,
    var password : String? =null,
    var department : String? = null,
    var address : String? = null,
    var createdAt : String? =null,
    var createdBy : String?=null,
    var staffRole : StaffRole?=null
): RealmObject()