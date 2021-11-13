package com.learning.LearningKotlin.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide collection of banks`() {
        //when
        val banks = mockDataSource.getBanks()

        //then
        assertThat(banks).isNotEmpty
    }

    @Test
    fun `should provide some mock data`() {
        //when
        val banks = mockDataSource.getBanks()

        //then
        assertThat(banks).allMatch{ it.accountNumber.isNotBlank() }
        assertThat(banks).allMatch{ it.transactionFee != 0 }
        assertThat(banks).anyMatch{ it.trust != 0.0 }
    }
}