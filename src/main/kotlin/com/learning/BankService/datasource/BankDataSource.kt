package com.learning.BankService.datasource

import com.learning.BankService.model.Bank

interface BankDataSource {
    fun getBanks(): Collection<Bank>
    fun getBank(accountNumber: String): Bank
}