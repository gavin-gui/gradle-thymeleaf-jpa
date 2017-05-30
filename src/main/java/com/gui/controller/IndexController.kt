package com.gui.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by gui on 2017/5/29.
 */

@Controller
@RequestMapping("/")
class IndexController {

    @RequestMapping
    fun index() : String = "login"

    @RequestMapping("login")
    fun login() : String = "login"

    @RequestMapping("register")
    fun registry() : String = "register"
}