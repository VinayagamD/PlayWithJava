package com.vinaylogics.playwithjava.solid.basics.srp;

public class BankService {

    public long deposit(long amount, String accountNo ){
        // deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo){
        // withdraw amount
        return 0;
    }

    public void printPassbook(){
        // update transaction info in passbook
    }

    public void getLoanInterestInfo(String loanType){
        switch (loanType) {
            case "homeLoan", "personalLoan", "car" -> {
                // do some job
            }
        }
    }

    public void sendOTP(String medium) {
        if(medium.equals("email")) {
            // write email related logic
            // use Java Mail SenderAPI
        }
    }
}
