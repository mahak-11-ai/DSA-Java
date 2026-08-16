package dsa_practice.Series_problem_solving;

import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter a no.");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int ori=n;
        System.out.println(isArmstrong(ori));
        
        sc.close();

    }
    static boolean isArmstrong(int ori){
        int sum=0, n=ori, count=0 ;
        while(n>0){
            count++;
            n/=10;
        }
        n=ori;
        while(n>0){
            int rem=n%10;
            n/=10;
            sum=sum+(int)Math.pow(rem, count);
        }
        return sum==ori;
    }
}
