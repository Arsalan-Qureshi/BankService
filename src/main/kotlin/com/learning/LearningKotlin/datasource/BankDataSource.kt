package com.learning.LearningKotlin.datasource

import com.learning.LearningKotlin.model.Bank

interface BankDataSource {
    fun getBanks(): Collection<Bank>
    fun getBank(accountNumber: String): Bank
}