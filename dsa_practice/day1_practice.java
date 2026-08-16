package dsa_practice;
import java.util.*;

public class day1_practice {
    public static void main(String[] args) {
        int arr[]={15,25,3,45,55};
        System.out.println(arr[0]);
        System.out.println(arr[4]);
        System.out.println(arr.length);

        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        for(int num:arr){
            System.out.println(num+" ");
        }

        String [] str={"apple","banana","mango","orange","grapes"};
        System.out.println(Arrays.toString(str));

        printArray(arr);
    }
    static void printArray(int []arr){
        System.out.println(Arrays.toString(arr));
    }
    
    
}
