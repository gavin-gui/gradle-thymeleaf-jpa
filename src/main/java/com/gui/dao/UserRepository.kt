package com.gui.dao

import com.gui.entity.User
import org.springframework.data.repository.CrudRepository

/**
 * Created by gui on 2017/5/29.
 */

interface UserRepository : CrudRepository<User,Long> {

    fun findByName(name: String): User

    fun findByEmail(email: String): User
}