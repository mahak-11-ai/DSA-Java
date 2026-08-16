package dsa_practice;
import java.util.*;

public class day1_arraysandarrayslist {
    public static void main(String[] args) {
        int [] arr=new int[5];
        Scanner sc=new Scanner(System.in);
         // input using for loops
        //  for(int i=0; i<arr.length; i++){
        //     arr[i]=sc.nextInt();
        //  }

        //  // print using for loop
        //  for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        //  }
        // System.out.println();
        //  // print using enhanced for loop= forEach loop

        //  for(int num: arr){
        //      System.out.print(num+" ");
        //  }
        // System.out.println();
        //  // print using ARRAY CLASS 
        //  System.out.println(Arrays.toString(arr));

         // string array= array of objects

         String []a=new String[4];
          for(int i=0; i<a.length;i++){
            a[i] = sc.next();
          }

          System.out.println(Arrays.toString(a));

          //modify 
          a[3]="mahak";

          System.out.println(Arrays.toString(a));




    }
    
}
