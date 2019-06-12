package com.uramnmoil.economycore

import com.uramnoil.economycore.repository.AccountRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.security.auth.login.AccountException

class AccountRepostiroyTest {
    @Test
    fun testCreateAccount() {
        val repo = AccountRepository(Any())

        val sample = repo.new(name = "sample")
        assert(sample.name == "sample")
        assert(sample.id == 0)
        assert(sample.money == 0)
        println("now testing")
    }

    @Test
    fun testDuplicateAccount() {
        val repo = AccountRepository(Any())

        repo.new("sample")
        assertThrows<AccountException> {
            repo.new(name ="sample")
        }
    }

    @Test
    fun testStoreAccount() {
        val repo = AccountRepository(Any())
        val sample1 = repo.new(name = "name")
        repo.store(sample1)
        val sample2 = repo.get(name = "sample") ?: throw AccountException()
        assert(sample2.name == "sample")
    }

    @Test
    fun testAddMoney() {
        val repo = AccountRepository(Any())
        val sample1 = repo.new(name = "sample")
        sample1.money = 100
        repo.store(account = sample1)
        val sample2 = repo.get("sample") ?: throw AccountException()
        assert(sample2.money == 100)
    }
}