package dsa_practice;

import java.util.Arrays;

public class day1_passingInFunctions {
    public static void main(String[] args) {
        int arr[]={20,4,67,12};
        System.out.print(Arrays.toString(arr));
        change(arr);
        System.out.print(Arrays.toString(arr));


    }
    static void change(int [] ar){
        ar[2]= 39;
    }
    
}
