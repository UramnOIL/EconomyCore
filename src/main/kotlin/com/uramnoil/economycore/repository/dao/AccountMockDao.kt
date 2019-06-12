package com.uramnoil.economycore.repository.dao

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.entity.AccountFactory

class AccountMockDao(): IAccountDao {
    private val list = arrayListOf<Account>()

    private var id = 0

    override fun select(id: Int): Account? = list.getOrNull(id)

    override fun select(name: String): Account? {
        for(entry in list) if(entry.name == name) return entry
        return null
    }

    override fun set(account: Account) {
        list[account.id] = account
    }

    override fun delete(account: Account): Boolean = list.remove(account)

    override fun create(name: String, money: Int): Account {
        if(select(name) == null)
            return AccountFactory.createAccount(name, id++, money)
        else
            throw AccountException()
    }

    override fun save() {}
}