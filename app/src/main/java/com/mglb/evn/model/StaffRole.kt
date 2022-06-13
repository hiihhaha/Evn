package com.mglb.evn.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*

open class StaffRole(
    @PrimaryKey
    var id: Int? = null,
    var roleId: Int?=null,
    var staffId: Int?=null,
    var role: Role?=null
) : RealmObject()