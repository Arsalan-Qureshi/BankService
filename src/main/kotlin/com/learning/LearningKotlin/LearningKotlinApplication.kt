package com.learning.LearningKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.ec2.Ec2Client

@SpringBootApplication
class LearningKotlinApplication {
    @Bean
    fun getEC2Client(): Ec2Client = Ec2Client
        .builder()
        .region(Region.US_EAST_2)
        .build()
}

fun main(args: Array<String>) {
    runApplication<LearningKotlinApplication>(*args)
}