package com.gui.controller

import com.gui.dao.UserRepository
import com.gui.entity.User
import com.gui.md5
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.sql.Timestamp
import javax.servlet.http.HttpSession

/**
 * Created by gui on 2017/5/29.
 */

@Controller
@RequestMapping("/auth")
class AuthController {

    private val log = LoggerFactory.getLogger(AuthController::class.java)

    @Autowired
    lateinit var userRepository : UserRepository;

    @RequestMapping("/register")
    fun registry(@RequestParam email : String, @RequestParam password : String,
                 @RequestParam(required = false) name : String?) : String {
        val user = User(email = email, password = password.md5(), name = name.orEmpty())
        user.whenCreated = Timestamp(System.currentTimeMillis())
        user.whenModified = Timestamp(System.currentTimeMillis())
        userRepository.save(user)
        log.info("registry success")
        return "forward:/auth/login"
    }

    @RequestMapping("/login")
    fun login(@RequestParam email : String, @RequestParam password : String,
              session : HttpSession) : String {
        log.info("email:${email}")
        val user = userRepository.findByEmail(email)

        if(user?.password.equals(password.md5())) {
            session.setAttribute("${user.id}",user)
            return "index"
        } else {
            log.error("user name or password valid")
            throw Exception("")
        }
    }

}