package com.greatlearning.algorithmlabsolution2.CurrencyService;

import java.util.Scanner;

public class CurrenyServiceClass {
	
	public void denominationArraySortCall(int arr[], int left, int right) {
		if(left<right) {
			int mid=(left+right)/2;
			denominationArraySortCall(arr,left,mid);
			denominationArraySortCall(arr,mid+1,right);
			denominationArrayMergeCall(arr,left,mid,right);
		}
	}
	
	public void denominationArrayMergeCall(int arr[],int left,int mid,int right) {
		int len1=mid-left+1;
		int len2=right-mid;
		
		int leftArr[]=new int[len1];
		int rightArr[]=new int[len2];
		
		for(int i=0;i<len1;i++) {
			leftArr[i]=arr[left+i];
		}
		for(int j=0;j<len2;j++) {
			rightArr[j]=arr[mid+1+j];
		}
		
		int i,j,k;
		i=0;
		j=0;
		k=left;
		
		while(i<len1 && j<len2) {
			//Sorting considered is in descending order
			if(leftArr[i]>=rightArr[j]) {
				arr[k]=leftArr[i];
				i++;
			} else {
				arr[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<len1) {
			arr[k]=leftArr[i];
			i++;
			k++;
		}
		
		while(j<len2) {
			arr[k]=rightArr[j];
			j++;
			k++;
		}
	}
	
	public int checkInt() {
		Scanner sc2=new Scanner(System.in);
		
		while (!sc2.hasNextInt()) {
			System.out.println("Please enter a positive integer value only. Try again.");
			return checkInt();
		}
		
		int input1=sc2.nextInt();
		
		while (input1<0) {
			System.out.println("Please enter a positive integer value only. Try again.");
			return checkInt();
		}
		
		return input1;
	}
	
	public int[] arrayInput(int size) {
		Scanner sc1=new Scanner(System.in);
		
		int arr[]=new int[size];
		
		for (int i=0; i<size; i++) {
			if(sc1.hasNextInt()) {
				arr[i]=sc1.nextInt();
			} else {
				System.out.println("Please enter positive integer values only. Enter all values again.");
				return arrayInput(size);
			}
		}
		
		for (int i=0; i<size; i++) {
			if (arr[i]<0) {
				System.out.println("Please enter positive integer values only. Enter all values again.");
				return arrayInput(size);
			}
		}
		
		return arr;
	}
	
	public int countNotes(int denominationsArray[],int counterArray[],int low,int high,int amountToPay) {
		
		if(amountToPay==0) {
			return 0;
		}
		if (amountToPay<denominationsArray[high]) {
			return amountToPay;
		}
		if (low==high) {
			counterArray[low]=amountToPay/denominationsArray[low];
			amountToPay=amountToPay%denominationsArray[low];
			return countNotes(denominationsArray,counterArray,low+1,denominationsArray.length-1,amountToPay);
		}
		int mid=(low+high)/2;
		if(amountToPay>=denominationsArray[mid]) {
			return countNotes(denominationsArray,counterArray,low,mid,amountToPay);
		} else {
			return countNotes(denominationsArray,counterArray,mid+1,denominationsArray.length-1,amountToPay);
		}
	}
	
}

