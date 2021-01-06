package nl.martijngroeneveldt;

import java.util.Scanner;

public class Main {
	static boolean DEBUG = true;

	public static void main(String[] args) {
		/*
		 * Parse input.
		 */
		Scanner scanner = new Scanner(System.in);
		// The number of products.
		int n = scanner.nextInt();
		// The number of dividers.
		int k = scanner.nextInt();
		// The array with the cost of the products in cents.
		int[] productCosts = new int[n];
		for (int i = 0; i < n; i += 1) {
			productCosts[i] = scanner.nextInt();
		}

		/*
		 * Perform a our algorithm.
		 */

		int total = cheapness(k, productCosts, 0, 0);


		/*
		 * Output data.
		 */
		System.out.println(total);
	}

	static int cheapness(int k, int[] arr, int sum, int i){
		System.out.println("k: " + k + " sum: " + sum + " i: " + i);
		if (i == arr.length){ // base case
			return roundedNumber(sum);
		}
		int newSum = sum + arr[i];
		if(k == 0) {
			return cheapness(k, arr, newSum, i + 1);
		}
		int temp1 = Integer.MAX_VALUE;
		int temp2 = Integer.MAX_VALUE;
		if(canBeOptimal(lastDigit(newSum))){
			// case 1: number can be optimal, but it is not guaranteed that placing the divider after it gives the optimal solution.
			temp1 = roundedNumber(newSum) + cheapness(k-1,arr, 0, i+1);
		}
		{
			// case 2: Number is not optimal, thus advance in the array.
			temp2 = cheapness(k, arr, newSum, i+1);
		}
		return Math.min(temp1,temp2);
	}

	static int roundedNumber(int x) {
		switch (lastDigit(x)) {
			case 1:
				return x - 1;
			case 2:
				return x - 2;
			case 3:
				return x + 2;
			case 4:
				return x + 1;
			case 6:
				return x - 1;
			case 7:
				return x - 2;
			case 8:
				return x + 2;
			case 9:
				return x + 1;
			default:
				return x;
		}
	}

	static int lastDigit(int x) {
		return x % 10;
	}

	static boolean isOptimal(int x) {
		return (x == 2 || x == 7);
	}

	static boolean isSubOptimal(int x) {
		return (x == 1 || x == 6);
	}

	static boolean canBeOptimal(int x) {
		return isSubOptimal(x) || isOptimal(x);
	}
}