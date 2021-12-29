package com.learning.BankService.service

import com.learning.BankService.datasource.BankDataSource
import com.learning.BankService.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.getBanks()

    fun getBank(accountNumber: String): Bank = dataSource.getBank(accountNumber)
}