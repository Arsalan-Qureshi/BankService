package com.learning.LearningKotlin.model

data class Bank(
    private val accountNumber: String,
    private val trust: Double,
    private val transactionFee: Int
)