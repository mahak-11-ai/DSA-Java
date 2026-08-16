package dsa_practice;
import java.util.*;
public class day2_2Darr{
    public static void main(String[] args) {
       // 2d array declaration
        // int[][]arr=new int[4][]; //it is not mandatory to write no. of columns 
        //or
        // int [][]array={
        //     {1,2,3},
        //     {4,5},          // size/ length of row is equal to size/length of 2d array 
        //     {6,7,8,9}
        // };
        // //print
        // for(int row=0;row<array.length;row++){
        //     for(int col=0;col<array[row].length;col++){
        //         System.out.print(array[row][col]+" ");
        //     }
        //      System.out.println();
        // }

        //input for arr
        Scanner sc= new Scanner(System.in);
         int[][]arr=new int[3][3];
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[row].length;col++){
                arr[row][col]=sc.nextInt();
            }
            //  System.out.println();
        }
        //output
        // for(int row=0;row<arr.length;row++){
        //     for(int col=0;col<arr[row].length;col++){
        //         System.out.print(arr[row][col]+" ");
        //     }
        //      System.out.println();
        // }

        //output using arraytostring
        // for(int row=0; row<arr.length;row++){
        //     System.out.println(Arrays.toString(arr[row]));
        // }

        //output using foreach loop
        for(int[] num:arr){ // here datatype of num is an array because the outer/main array- arr consists arrays in it 
            System.out.println(Arrays.toString(num));
        }
    }
}