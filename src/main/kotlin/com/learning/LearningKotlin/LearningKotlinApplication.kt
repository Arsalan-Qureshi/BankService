package com.learning.LearningKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ec2.Ec2Client

@SpringBootApplication
class LearningKotlinApplication

fun main(args: Array<String>) {
    runApplication<LearningKotlinApplication>(*args)
}