package com.uramnoil.economycore

import com.uramnoil.economycore.repository.AccountRepository
import com.uramnoil.economycore.repository.IAccountRepostirory
import com.uramnoil.economycore.repository.dao.AccountMockDao

class EconomyCore{
    val repostirory: IAccountRepostirory = AccountRepository(AccountMockDao())
}