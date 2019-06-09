package com.uramnoil.economycore.repository

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.repository.cache.AccountCache
import com.uramnoil.economycore.repository.dao.IAccountDao

object AccountRepository: IAccountRepostirory {
    override val dao: IAccountDao
    val cache = AccountCache()

    override fun set(account: Account) {
        dao.set(account)
        cache.cache(account)
    }

    override fun get(id: Int): Account? {
        return if(cache.isCached(id)) cache.get(id) else dao.select(id)
    }

    override fun get(name: String): Account? {
        return if(cache.isCached(name)) cache.get(name) else dao.select(name)
    }

    override fun delete(account: Account) {
        dao.delete(account)
    }

    override fun save() {
        dao.save()
    }
}