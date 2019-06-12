package com.uramnmoil.economycore

import com.uramnoil.economycore.repository.AccountRepository
import com.uramnoil.economycore.repository.dao.AccountException
import com.uramnoil.economycore.repository.dao.AccountMockDao
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountRepostiroyTest {
    val aRepo by lazy {
        AccountRepository(AccountMockDao())
    }

    @Test
    fun testCreateAccount() {
        val repo = aRepo

        val sample = repo.new(name = "sample")
        assert(sample.name == "sample")
        assert(sample.id == 0)
        assert(sample.money == 0)
    }

    @Test
    fun testDuplicateAccount() {
        val repo = aRepo

        repo.new("sample")
        assertThrows<AccountException> {
            repo.new(name ="sample")
        }
    }

    @Test
    fun testStoreAccount() {
        val repo = aRepo
        val sample1 = repo.new(name = "sample")
        repo.store(sample1)
        val sample2 = repo.get("sample") ?: throw AccountException()
        assert(sample2.name == "sample")
    }

    @Test
    fun testAddMoney() {
        val repo = aRepo
        val sample1 = repo.new(name = "sample")
        sample1.money = 100
        val sample2 = repo.get("sample") ?: throw AccountException()
        assert(sample2.money == 100)
    }
}