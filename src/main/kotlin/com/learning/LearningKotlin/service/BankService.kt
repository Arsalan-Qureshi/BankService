package com.learning.LearningKotlin.service

import com.learning.LearningKotlin.datasource.BankDataSource
import com.learning.LearningKotlin.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.getBanks()

    fun getBank(accountNumber: String): Bank = dataSource.getBank(accountNumber)
}