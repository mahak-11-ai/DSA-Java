package dsa_practice;
import java.util.ArrayList;
import java.util.Scanner;

public class day3_ArrayList {
    public static void main(String[] args) {
        //syntax of arraylist
        ArrayList<Integer> list=new ArrayList<>(5); // you can add as much values as you want it "never" gets full
                                                                     // even if initial capacity is 5

        // list.add(34);
        // list.add(12);
        // list.add(13);
        // list.add(45);
        // list.add(678);
        // list.add(345);
        // list.add(100);
        
        // System.out.println(list);

        // System.out.println(list.contains(678));//true

        // System.out.println(list.set(2,809));

        // System.out.println(list.remove(1));

        // System.out.print(list);

        Scanner sc= new Scanner (System.in);
        //input
        for(int i=0; i<5;i++){
            list.add(sc.nextInt());
        }

        //output
        for(int i=0;i<5;i++){
            // to get value op at an index
            System.out.println(list.get(i)); //you cannot get value if you put list[index], correct method list.get(index)
        }
        //or
        //System.out.println(list);


    }
    
}
