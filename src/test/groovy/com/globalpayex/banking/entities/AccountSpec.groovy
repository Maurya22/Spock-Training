package com.globalpayex.banking.entities

import spock.lang.Specification

class AccountSpec extends Specification {
    def "Withdraw"() {
        given:
        def account = new Account(accNumber: 'ABC123',accType: 'saving', balance: 5000.0)

        when:
        def actual = account.withdraw(2000)

        then:
        actual == 3000

        verifyAll(account){
            balance == 3000
            accType == 'saving'
            accNumber =='ABC123'
        }
    }

    def "Deposite"() {
        given:
        def account = new Account(accNumber: 'ABC123',accType: 'saving', balance: 5000.0)

        when:
        def actual = account.deposite(2000)

        then:
        actual == 7000
       /* account.balance == 7000
        account.accType == 'saving' */
        /*with(account){
            balance == 7000
            accType =='saving'
        }*/
//        verifyAll(account){
//            balance == 7000
//            accType == 'saving'
//            accNumber =='ABC123'
//        }
        verify(account,7000,'saving','ABC123')

    }
    void verify(account, pbalance, paccType,paccNumber){
        verifyAll(account){
            assert account.balance == pbalance
           assert  account.accType == paccType
           assert  account.accNumber == paccNumber
        }
    }

}
