package Arrays;


import java.util.Scanner;

public class MissingNumber_268 {
    static int missingNo(int [] nums){
        int sum=0;
        int n=nums.length;
        int actualSum= n*(n+1)/2;
        for(int num:nums){
            sum += num;
        }
        return actualSum-sum;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n=sc.nextInt();
        int [] nums= new int [n];
        System.out.println("Enter array elements: ");
        for(int i=0; i<n; i++){
            nums[i]= sc.nextInt();
        }
        System.out.println(missingNo(nums));
        sc.close();
         


    }
    
}
