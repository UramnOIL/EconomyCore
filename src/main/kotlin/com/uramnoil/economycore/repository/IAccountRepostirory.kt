package com.uramnoil.economycore.repository

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.entity.AccountFactory
import com.uramnoil.economycore.repository.dao.IAccountDao

interface IAccountRepostirory {
    val dao: IAccountDao

    fun new(name: String, money: Int) {
        dao.new(name, money)
    }

    fun store(account: Account)
    fun get(id: Int): Account?
    fun get(name: String): Account?
    fun delete(account: Account): Boolean
    fun save()
}