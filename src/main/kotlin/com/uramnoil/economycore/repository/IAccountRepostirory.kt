package com.uramnoil.economycore.repository

import com.uramnoil.economycore.entity.Account
import com.uramnoil.economycore.repository.dao.IAccountDao

interface IAccountRepostirory {
    val dao: IAccountDao

    fun set(account: Account)
    fun get(id: Int): Account?
    fun get(name: String): Account?
    fun delete(account: Account)
    fun save()
}