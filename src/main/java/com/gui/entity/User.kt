package com.gui.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.iostate.bms.entity.BaseModel
import javax.persistence.Entity

@Entity
class User (
    var email: String = "",
    @JsonIgnore
    var password: String = "",
    var name: String = "",
    var introduction: String = "",
    var deleted: Boolean = false
) : BaseModel()