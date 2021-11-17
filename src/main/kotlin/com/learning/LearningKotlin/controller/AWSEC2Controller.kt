package com.learning.LearningKotlin.controller

import com.learning.LearningKotlin.service.AWSEC2Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/aws/ec2")
class AWSEC2Controller(@Autowired val awseC2Service: AWSEC2Service) {

    @GetMapping("/greeting")
    fun sampleFunction(): String = "Hello World!"

    @GetMapping("/createInstance/{name}/{amiId}")
    fun createEC2Instance(@PathVariable("name") name: String, @PathVariable("amiId") amiId: String): String? =
        awseC2Service.createEC2Instance(name, amiId)

    @GetMapping("/startInstance/{instanceId}")
    fun startInstance(@PathVariable("instanceId") instanceId: String): Unit =
        awseC2Service.startInstance(instanceId)

    @GetMapping("/stopInstance/{instanceId}")
    fun stopInstance(@PathVariable("instanceId") instanceId: String): Unit =
        awseC2Service.stopInstance(instanceId)

    @GetMapping("/rebootInstance/{instanceId}")
    fun rebootEC2Instance(@PathVariable("instanceId") instanceId: String): Unit =
        awseC2Service.rebootEC2Instance(instanceId)

    @GetMapping("/describeInstance")
    fun describeEC2Instances(): Unit = awseC2Service.describeEC2Instances()

    @GetMapping("/monitorInstance/{instanceId}")
    fun monitorInstance(@PathVariable("instanceId") instanceId: String): Unit =
        awseC2Service.monitorInstance(instanceId)

    @GetMapping("/unmonitorInstance/{instanceId}")
    fun unmonitorInstance(@PathVariable("instanceId") instanceId: String): Unit =
        awseC2Service.unmonitorInstance(instanceId)
}