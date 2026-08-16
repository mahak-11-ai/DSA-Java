package dsa_practice.Series_problem_solving;
import java.util.Scanner;
public class Convert_a_to_A {
    public static void main(String[] args) {
        char name;
        Scanner sc= new Scanner(System.in);
        name=sc.next().charAt(0);
        System.out.println(Convert(name));
        sc.close();

    }
    static char Convert(char name){
        char ans=(char)(name-'a'+'A');
        return ans;

    }
    
}
