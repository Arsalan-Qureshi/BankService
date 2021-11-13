package com.learning.LearningKotlin.controller

import com.learning.LearningKotlin.model.Bank
import com.learning.LearningKotlin.service.BankService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("api")
class BankController(private val service: BankService) {
    @GetMapping("/banks")
    @ResponseBody
    fun getBanks(): Collection<Bank> = service.getBanks()

    @GetMapping("/bank/{accountNumber}")
    @ResponseBody
    fun getBank(@PathVariable("accountNumber") accountNumber: String): Bank = service.getBank(accountNumber)
}