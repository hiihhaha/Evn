package com.mglb.evn.utils

import com.mglb.evn.model.ROLE_ADMIN
import com.mglb.evn.model.StaffModel

 fun StaffModel.isAdmin() : Boolean {
    return  staffRole?.roleId == ROLE_ADMIN
}