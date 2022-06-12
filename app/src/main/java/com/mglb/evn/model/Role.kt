package com.mglb.evn.model

import io.realm.RealmObject

class Role(
    var id: Int,
    var name: String? = null,
    var description: String? = null,
    var roleActionId: Int,
    var creatAt: String,
    var creatBy: Int,
    var roleAction: RoleAction

) : RealmObject()
const val ROLE_ADMIN = 0
const val  ROLE_STAFF = 1