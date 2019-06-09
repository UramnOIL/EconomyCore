package com.uramnoil.economycore.repository.cache

import com.uramnoil.economycore.entity.Account

class AccountCache {
    val cache = arrayListOf<Account>()
    fun cache(account: Account) {
        cache[account.id] = account
    }
    fun isCached(id: Int): Boolean = cache.getOrNull(id) is Account

    fun isCached(name: String): Boolean = cache.filter{ account -> account.name == name }.count() == 1

    fun get(id: Int) = cache[id]

    fun get(name: String): Account {
        for (entry in cache) {
            if(entry.name == name) {
                return entry
            }
        }
        throw NotCachedException()
    }
}