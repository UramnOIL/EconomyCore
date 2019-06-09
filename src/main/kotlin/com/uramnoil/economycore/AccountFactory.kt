package com.uramnoil.economycore

import com.uramnoil.economycore.entity.Account

class AccountFactory {
    companion object {
        fun createAccount(name: String, money: Int): Account = Account(name = name, id = -1, money = money)
    }
}