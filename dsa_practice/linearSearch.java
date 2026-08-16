package dsa_practice;
import java.util.*;
class linearSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter no. of elements");
        int n= sc.nextInt();
        System.out.println("enter array elements= ");
        int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter element to search:");
        int target= sc.nextInt();
        System.out.println(search(arr,target)); 
        
        sc.close();
    }
    static boolean search(int [] arr, int target){ 
        if (arr.length==0){
            return false;
        }
        for(int element: arr){
            if(element==target){
                return true;
            }
        }
        return false;

    }
}