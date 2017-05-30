package com.gui.controller

import com.gui.dao.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by gui on 2017/5/29.
 */
@Controller
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userRepository : UserRepository

    @RequestMapping
    fun userList(model: Model) : String {
        val userList = userRepository.findAll()
        model.addAttribute("users",userList)
        return "user-list"
    }
}

