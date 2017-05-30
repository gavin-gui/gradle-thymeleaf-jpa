package com.gui

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by gui on 2017/5/29.
 */
@SpringBootApplication
open class GradleThymeleafJpaApplication {

}

fun main(args : Array<String>) {
    run(GradleThymeleafJpaApplication::class.java,*args)
}