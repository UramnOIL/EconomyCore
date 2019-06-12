package com.uramnoil.economycore.repository

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.repository.cache.AccountCache
import com.uramnoil.economycore.repository.dao.AccountException
import com.uramnoil.economycore.repository.dao.AccountMockDao
import com.uramnoil.economycore.repository.dao.IAccountDao

class AccountRepository(override val dao: IAccountDao): IAccountRepostirory {
    val cache = AccountCache()

    override fun new(name: String, money: Int): Account {
        if(cache.hasCached(name))
            throw AccountException()
        else {
            val account = dao.create(name, money)
            cache.cache(account)
            return account
        }
    }

    override fun store(account: Account) {
        cache.cache(account)
    }

    override fun get(id: Int): Account? = if(cache.hasCached(id)) cache.get(id) else dao.select(id)

    override fun get(name: String): Account? = if(cache.hasCached(name)) cache.get(name) else dao.select(name)

    override fun delete(account: Account): Boolean {
        cache.delete(account)
        return dao.delete(account)
    }

    override fun save() {
        cache.all.forEach{ dao.set(it) }
        dao.save()
    }
}