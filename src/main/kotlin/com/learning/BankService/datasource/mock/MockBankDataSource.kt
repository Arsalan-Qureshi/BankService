package com.learning.BankService.datasource.mock

import com.learning.BankService.datasource.BankDataSource
import com.learning.BankService.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf(Bank("0011-0011", 100.0, 2500))

    override fun getBanks(): Collection<Bank> = banks

    override fun getBank(accountNumber: String): Bank = banks.first { it.accountNumber == accountNumber }
}