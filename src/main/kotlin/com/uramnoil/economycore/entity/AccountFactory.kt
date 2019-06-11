package com.uramnoil.economycore.entity

import com.uramnoil.economycore.entity.Account

class AccountFactory {
    companion object {
        fun createAccount(name: String, id: Int, money: Int): Account = Account(name = name, id = -1, money = money)
    }
}