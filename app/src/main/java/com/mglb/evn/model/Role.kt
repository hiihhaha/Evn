package com.mglb.evn.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Role(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var description: String? = null,
    var roleActionId: Int? = null,
    var createAt: String?=null,
    var createBy: Int?=null,
    var roleAction: RoleAction?=null

) : RealmObject()

const val ROLE_ADMIN = 0
const val  ROLE_STAFF = 1