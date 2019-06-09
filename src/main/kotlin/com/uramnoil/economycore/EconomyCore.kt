package com.uramnoil.economycore

import com.uramnoil.economycore.repository.AccountRepository
import com.uramnoil.economycore.repository.IAccountRepostirory

class EconomyCore{
    val repostirory: IAccountRepostirory = AccountRepository
}