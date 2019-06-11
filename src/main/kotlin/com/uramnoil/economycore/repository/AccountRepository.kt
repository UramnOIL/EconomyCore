package com.uramnoil.economycore.repository

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.repository.cache.AccountCache
import com.uramnoil.economycore.repository.dao.AccountMockDao
import com.uramnoil.economycore.repository.dao.IAccountDao

object AccountRepository: IAccountRepostirory {
    override val dao: IAccountDao = AccountMockDao()
    val cache = AccountCache()

    override fun store(account: Account) {
        cache.cache(account)
    }

    override fun get(id: Int): Account? = if(cache.isCached(id)) cache.get(id) else dao.select(id)

    override fun get(name: String): Account? = if(cache.isCached(name)) cache.get(name) else dao.select(name)

    override fun delete(account: Account): Boolean {
        cache.delete(account)
        return dao.delete(account)
    }

    override fun save() {
        cache.all.forEach{ dao.set(it) }
        dao.save()
    }
}