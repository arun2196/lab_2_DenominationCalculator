package com.gl.lab_2_denomination_counter;
import java.util.Scanner;
public class UserInput {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the size of currency denominations\n ");

        n=sc.nextInt();
        int paymentAmount;
        int[] denomination = new int[n];
        System.out.println("enter the currency denominations value\n\n ");
        for(int i=0; i<n; i++)
        {
            denomination[i]=sc.nextInt();
        }
        System.out.println("Enter the target that needs to be achieved");
        paymentAmount = sc.nextInt();
        DenominationCalculator DC = new DenominationCalculator(denomination,paymentAmount );
        DC.calculate();
    }
}
