package com.globalpayex.banking.entities

class Account {

    String accNumber
    String accType
    BigDecimal balance

    def BigDecimal withdraw(BigDecimal amt){
        this.balance -= amt
    }
    def BigDecimal deposite(BigDecimal amt){
        this.balance += amt
    }
}
