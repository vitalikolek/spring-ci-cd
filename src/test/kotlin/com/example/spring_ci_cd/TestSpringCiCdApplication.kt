package com.example.spring_ci_cd

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<SpringCiCdApplication>().with(TestcontainersConfiguration::class).run(*args)
}
