package com.mglb.evn.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

class StaffRole(
    @PrimaryKey
    var id: Int = 0,
    var roleId: Int?=null,
    var staffId: Int?=null,
    var role: Role?=null
) : RealmObject()