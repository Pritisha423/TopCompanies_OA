package LinkedlnSep23_OA;

// Given an array of numbers, find the index of the smallest array element(the pivot), for which the sums of all elements to the left and to the rigth are equal.
// The array may not be reordered.

// Example: 
//  arr=[1,2,3,4,6]
//  explanation -> first 3 element sum is 1+2+3 = 6
//                 and from right side we get 6 in fifth position.
//                 6 < - 4 - > 6 ; 4 will be the pivot element. left of 4 the sum is 6 and same for right.


// Approach : 
//              We can solve this question easily using prefix sum.
//              prefix sum array = [1,3,6,10,16]
//              Start from right check for every index is ((array[i]-array[i-1])==array[i-2]) where i goes from n-1 to 0.
//              if((array[i]-array[i-1])==array[i-2]) return i-1;


import java.util.*;

public class Question1 {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int prefixsum[] = new int[n];
		prefixsum[0]=arr[0];
		for(int i=1;i<n;i++) {
			prefixsum[i]=prefixsum[i-1]+arr[i];
		}
		
		for(int i=n-1; i-2>=0; i--) {
			int t = prefixsum[i]- prefixsum[i-1];
			if(t==prefixsum[i-2]) {
				System.out.println(i-1);
				return;
			}
		}
		
	}

}
