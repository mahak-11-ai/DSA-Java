package dsa_practice;

import java.util.Scanner;

public class OrderAgnostic {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n= sc.nextInt();
        System.out.println("Enter sorted value for a array: ");
        int arr[]= new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        System.out.println("Enter value of target: ");
        int target = sc.nextInt();
       
        int result= BinarySearch(arr, target);
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found");
        }
        sc.close();
    }
    static int BinarySearch(int []arr, int target){
        int start=0;
        int end=arr.length-1;
        boolean isAsc = arr[start]<arr[end];
       
        while(start<=end){
            int mid = start+ (end-start)/2;
             if(arr[mid]==target){
                return target;
             }
            if(isAsc){
                if(target>arr[mid]){
                   start=mid+1;
                }
                else if(target<arr[mid]){
                  // end=mid-1;
                   end=mid-1;
                }
            }else{
                 if(target>arr[mid]){
                   end=mid-1;

                 }
                 else if(target<arr[mid]){
                   start=mid+1;
                 }
            }
            
        }
        return -1;
    }
    
    
}
