package com.uramnoil.economycore.repository.dao

import com.uramnoil.economycore.entity.Account

interface IAccountDao {
    fun select(id: Int): Account?
    fun select(name: String): Account?
    fun set(account: Account)
    fun delete(account: Account): Boolean
    fun create(name: String, money: Int): Account
    fun save()
}