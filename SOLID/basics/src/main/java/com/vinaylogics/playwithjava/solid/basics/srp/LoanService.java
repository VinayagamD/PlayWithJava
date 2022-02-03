package com.vinaylogics.playwithjava.solid.basics.srp;

public class LoanService {

    public void getLoanInterestInfo(String loanType) {
        switch (loanType) {
            case "homeLoan", "personalLoan", "car" -> {
                // do some job
            }
        }
    }
}