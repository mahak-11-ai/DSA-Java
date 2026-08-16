package dsa_practice.linearSearch_ques;

import java.util.Arrays;

public class q4_searchin_2Darray {
    public static void main(String[] args) {
        int [][] arr={
            {1,2,3,4,5},
            {12,34,56,67,89,90},
            {2,0}
        };
        int target= 56;
        int [] ans=search(arr,target);
        System.out.println(Arrays.toString(ans));
        System.out.println(max(arr));
    }
    static int []search(int [][]arr,int target){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr.length; col++){
                if(arr[row][col]==target){
                    return new int []{row,col};
                }

            }
        }
        
        // enhanced for loop - does'nt work because we require index as result and it returns element at the index
        return new int[]{-1,-1};

    }
    static int max(int [][] arr){
        int max=Integer.MIN_VALUE;
        for(int [] row:arr){
            for(int ele:row){
                if(max<ele){
                max=ele;
            }
            }
            
        }
        return max;
    }
}
