package com.uramnoil.economycore.repository.cache

import com.uramnoil.economycore.entity.Account

class AccountCache {
    private val cache = arrayListOf<Account>()
    val all: List<Account>
        get() = cache

    fun cache(account: Account) {
        cache.add(account.id, account)
    }

    fun hasCached(id: Int): Boolean = cache.getOrNull(id) is Account

    fun hasCached(name: String): Boolean = cache.filter{ account -> account.name == name }.count() >= 1

    fun get(id: Int) = cache[id]

    fun get(name: String): Account {
        for (entry in cache) {
            if(entry.name == name) {
                return entry
            }
        }
        throw NotCachedException()
    }

    fun delete(account: Account) = cache.remove(account)
}