package com.learning.LearningKotlin.service

import com.learning.LearningKotlin.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    // mockk(relaxed = true) will return something rather than nothing
    private val dataSource: BankDataSource = mockk()

    private val bankService = BankService(dataSource)

    @Test
    fun `should call data source to get banks`() {
        //given
        every { dataSource.getBanks() } returns emptyList()

        // when
        bankService.getBanks()

        // then
        verify(exactly = 1) { dataSource.getBanks() }
    }
}