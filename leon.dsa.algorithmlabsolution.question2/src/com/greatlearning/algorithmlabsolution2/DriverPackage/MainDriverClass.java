package com.greatlearning.algorithmlabsolution2.DriverPackage;

import java.util.Arrays;

import com.greatlearning.algorithmlabsolution2.CurrencyService.CurrenyServiceClass;

public class MainDriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CurrenyServiceClass payment=new CurrenyServiceClass();
		
		System.out.println("Enter size of currency denominations array");
		int size=payment.checkInt();
		
		int denominationsArray[]=new int[size];
		int counterArray[]=new int[size];
		
		System.out.println("Enter the currency denominations values");
		
		denominationsArray=payment.arrayInput(size);
		payment.denominationArraySortCall(denominationsArray,0,size-1);
		
		System.out.println("Enter amount to be paid");
		int amountToPay=payment.checkInt();
		
		int remainingAmt=payment.countNotes(denominationsArray,counterArray,0,denominationsArray.length-1,amountToPay);
		
		if(remainingAmt>0) {
			System.out.println("The amount cannot be paid fully. Try getting lower denominations");
		} else {
			System.out.println("Your payment approach in order to give min no of notes will be ");
			for(int i=0;i<size;i++) {
				if(counterArray[i]>0) {
					System.out.println(denominationsArray[i]+":"+counterArray[i]);
				}
			}
		}

	}

}
