package com.mglb.evn.model

import io.realm.RealmObject

class RoleAction(
    var id : Int,
    var createStaff : Int,
    var editStaff : Int,
    var deleteStaff : Int,
    var createRole : Int,
    var editRole : Int,
    var deleteRole : Int,
    var createdAt : String,
    var createBy : Int
) : RealmObject()