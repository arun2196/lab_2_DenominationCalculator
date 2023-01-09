package com.gl.lab_2_denomination_counter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class DenominationCalculator {
    private int[] denominations;
    private int paymentAmount;

    public DenominationCalculator(int[] denominations, int paymentAmount) {
        this.denominations = denominations;
        this.paymentAmount = paymentAmount;
    }

    public int[] getDenominations() {
        return denominations;
    }

    public void setDenominations(int[] denominations) {
        this.denominations = denominations;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    private boolean outcome;

    public void calculate(){
        Arrays.sort(denominations);
        StringBuilder result = new StringBuilder();
        result.append(String.format("Amount to pay : %d", paymentAmount));
               result. append(System.getProperty("line.separator"));
        int tempAmount = paymentAmount;
        try {
            for (int index = denominations.length-1; index >=0; index--) {

                int denominationValue = denominations[index];
                int quotient = tempAmount / denominationValue;
                int remainder = tempAmount % denominationValue;

                if (quotient == 0)
                    System.out.println("This denomination cannot be considered for the final outcome");
                else {
                    result.append(String.format("Denomination : %d, Count : %d", denominationValue, quotient));
                    result.append(System.getProperty("line.separator"));
                    tempAmount = remainder;
                }
                if (remainder == 0) {
                    this.outcome = true;
                    break;
                }
            }
        } catch (ArithmeticException arithmeticException){
            arithmeticException.printStackTrace();
        }
        if (outcome){
            System.out.println("Success \n" + result);
        }
        else {
            System.out.println("Failure");
            result.append(String.format("unable to provide denomination for the balance amount of %d", tempAmount));
            System.out.println(result);
        }

    }
}
