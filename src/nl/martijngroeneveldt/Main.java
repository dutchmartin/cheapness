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
		var n = scanner.nextInt();
		// The number of dividers.
	    var k = scanner.nextInt();
	    // The array with the cost of the products in cents.
	    var productCosts = new int[n];
	    for(int i = 0; i < n; i+=1) {
	    	productCosts[i] = scanner.nextInt();
	    }

	    /*
	     * Perform a our algorithm.
	     */
	    int totalCost = 0;
	    int currentCost = productCosts[0];
	    for (int i = 1; i < productCosts.length; i++) {
			currentCost += productCosts[i];
			var lastDigit = lastDigit(currentCost);
			if(isOptimalDigit(lastDigit) && k > 0 ){
				// round total
				var realCost = 0;
				//if lastDigit >
				totalCost += 0;
				currentCost = 0;
				k--;
				if(DEBUG)
					System.out.println("Placed a bar after: " + productCosts[i] + " when i="+ i);
			}
	    }
		totalCost += currentCost;

	    /*
	     * Output data.
	     */
	    System.out.println(totalCost);
    }

    static int lastDigit(int x) {
    	return x % 10;
    }

    static boolean isOptimalDigit(int x) {
    	// This can also be x % 5 == 2 || 1, but 4 times a int compare is probably cheaper.
    	return (x==1 || x==2 || x==6 || x==7);
	    //return (x==2 || x==7);
    }
}
