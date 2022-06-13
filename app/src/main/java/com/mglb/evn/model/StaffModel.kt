package com.mglb.evn.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.io.Serializable
import java.util.*

open class StaffModel(
    @PrimaryKey
    var id : Int? = null,
    var firstName : String? =null,
    var lastName : String? = null,
    var email : String? = null,
    var password : String? =null,
    var department : String? = null,
    var address : String? = null,
    var createdAt : String? =null,
    var createdBy : String?=null,
    var staffRole : StaffRole?=null
): RealmObject(), Serializable