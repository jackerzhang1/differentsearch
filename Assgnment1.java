/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assgnment1;

import java.util.Random;
import java.util.*;
import com.github.sh0nk.matplotlib4j.builder.ContourBuilder;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
  
public class Assgnment1 {

  public static int[] random_list(int max_int, int min, int size, boolean do_sort) {
		int[] arr = new int[size];
		Random rand = new Random();
		for(int i=0; i<size; i++) {
			arr[i] = rand.nextInt(max_int - min + 1) + min;
		}
		if(do_sort) {
			Arrays.sort(arr);
		}
		return arr;
	}
  public static  int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
        // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid; 
            // If element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
 public static int interpolationSearch(int arr[], int lo,  int hi, int x)
    {
        int pos;
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
 
            // Probing the position with keeping uniform distribution in mind.
            pos = lo + (((hi - lo) / (arr[hi] - arr[lo]))* (x - arr[lo]));
            // Condition of target found
            if (arr[pos] == x)
                return pos;
            // If x is larger, x is in right sub array
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi,  x);
 
            // If x is smaller, x is in left sub array
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1,x);
        }
        return -1;
    }
   public static int search(int arr[], int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    public static int jumpSearch(int[] arr, int x)
    {
        int n = arr.length;
        // Finding block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));
        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n)-1] < x)
        {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }
 
        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x)
        {
            prev++;
 
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }
 
        // If element is found
        if (arr[prev] == x)
            return prev;
 
        return -1;
    }
 
    public static void main(String[] args)
    {
     Random rand = new Random();
     int key;
       int  max_int = 1000000;
  int  size = 10000;   int min=5;  int idx=0;
int[]arr = random_list(max_int, min, size, true);
   
	for(int i=0; i<size; i++) {
    idx= rand.nextInt();
        key=arr[i];
  	
   
        int n = arr.length;
           int result1 = search(arr, key);
     /*   int index = interpolationSearch(arr, 0, n - 1, x);
        int result = binarySearch(arr, 0, n - 1, x);
        int index1= jumpSearch(arr, x);*/
    //      System.out.println("key chosen in position " +key);
       System.out.println("linear Search "    + result1);
    //    System.out.println("binarySearch "    + result);
        //    System.out.println("interpolationSearch:" + index);
        //   System.out.println("jump Search:" + index1);
    }

}